package com.bank.bank.account.persistance;

import java.util.List;
import java.util.Optional;

import com.bank.bank.account.models.OperationBancaire;

public interface OperationBancaireDao {
    void deleteByIdOperation(int idOperation);

    OperationBancaire save(OperationBancaire operationBancaire);

    void update(OperationBancaire operationBancaire);

    Optional<OperationBancaire> findByIdOperation(int idOperation);

    List<OperationBancaire> findAll();
}
