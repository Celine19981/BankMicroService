package com.bank.bank.account.models;

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
public class Account {
    @Id
    @Column
    String iban;

    @Column
    String accountType;
    
    @Column
    double interest;

    @Column
    double expenses;

 
}
