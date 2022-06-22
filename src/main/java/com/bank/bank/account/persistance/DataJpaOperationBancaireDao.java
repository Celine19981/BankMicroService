package com.bank.bank.account.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bank.account.models.OperationBancaire;

@Repository
public interface DataJpaOperationBancaireDao extends OperationBancaireDao, JpaRepository<OperationBancaire, String>{
    
}
