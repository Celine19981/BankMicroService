package com.bank.bank.core.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class SearchSpecification<T> implements Specification<T> {
    private static enum Operator {
        EQ(Pattern.compile("^(.*)=([^%]*)$")),
        LT(Pattern.compile("^(.*)<(?!=)(.*)$")),
        GT(Pattern.compile("^(.*)>(?!=)(.*)$")),
        LTE(Pattern.compile("^(.*)<=(.*)$")),
        GTE(Pattern.compile("^(.*)>=(.*)$")),
        LIKE(Pattern.compile("^(.*)=(.*%.*)$"));

        private Operator(Pattern pattern) {
            this.pattern = pattern;
        }

        final Pattern pattern;
    }

    private static class Operation<T> implements Serializable {
        private final String attribute;
        private final Operator operator;
        private final String value;

        public Operation(String field, Operator operator, String value) {
            this.attribute = field;
            this.operator = operator;
            this.value = value;
        }

    private Path<String> resolvePath(Root<T> root, String attribute) {
        String[] parts = attribute.split("\\.");
        
        Path<String> path = root.get(parts[0]);
        for(int i = 1; i < parts.length; i++) {
            path.get(parts[i]);
        }

        return path;
    }

        public Predicate getPredicate(Root<T> root, CriteriaBuilder cb) {
            Path<String> path = resolvePath(root, attribute);
            switch (operator) {
                case LT:
                    return cb.lessThan(path, value);
                case LTE:
                    return cb.lessThanOrEqualTo(path, value);
                case GT:
                    return cb.greaterThan(path, value);
                case GTE:
                    return cb.greaterThanOrEqualTo(path, value);
                case EQ:
                    return cb.equal(path, value);
                case LIKE:
                    return cb.like(cb.upper(path), value.toUpperCase());
                default:
                    throw new UnsupportedOperationException("Unsupported operator: " + operator);
            }
        }
    }

    private final List<Operation<T>> operations;

    public SearchSpecification(String search) {
        parse(search, operations = new ArrayList<>());
    }

    void parse(String search, List<Operation<T>> operations) {
        for (String ct : search.split(",")) {
            for (Operator o : Operator.values()) {
                var matcher = o.pattern.matcher(ct);
                if (matcher.matches()) {
                    String attributeName = matcher.group(1);
                    String value = matcher.group(2);
                    operations.add(new Operation<>(attributeName, o, value));
                    break;
                }
            }
        }
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        if (operations.isEmpty())
            return null;
        var pred = operations.get(0).getPredicate(root, cb);
        for (int i = 1; i < operations.size(); i++) {
            pred = cb.and(pred, pred = operations.get(i).getPredicate(root, cb));
        }
        return pred;
    }
}
