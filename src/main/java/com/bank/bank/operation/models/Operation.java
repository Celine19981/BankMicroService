package com.bank.bank.operation.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bank.bank.account.models.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Operation {
    @Id
    Integer id;

    String type;

    @JsonIgnore
    String source;

    @JsonIgnore
    String destination;

    @ManyToOne
    @JoinColumn(name = "source", updatable = false, insertable = false)
    Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "destination", updatable = false, insertable = false)
    Account destinationAccount;

    String currency;

    double ammount;

    Timestamp operationDate;
}
