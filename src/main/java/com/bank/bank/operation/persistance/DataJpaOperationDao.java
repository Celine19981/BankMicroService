package com.bank.bank.operation.persistance;

import java.sql.Timestamp;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bank.operation.models.Operation;

@Repository
public interface DataJpaOperationDao extends OperationDao, JpaRepository<Operation, String>{
    @Override
    default Operation saveOperation(Operation operation) {
        while (true) {
            int id = RandomUtils.nextInt(1, Integer.MAX_VALUE);
            if (findById(id).isEmpty()) {
                operation.setId(id);
                operation.setOperationDate(new Timestamp(System.currentTimeMillis()));
                return save(operation);
            }
        }
    }
}
