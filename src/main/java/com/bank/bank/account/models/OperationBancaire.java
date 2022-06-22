package com.bank.bank.account.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
public class OperationBancaire {
   
    @Id
    @Column
    int idOperation;

    @Column
    String operationType;

    @Column
    String ibanSource;
    
    @Column
    String ibanDestination;

    @Column
    double montant;

    @Column
    Date date;
}



