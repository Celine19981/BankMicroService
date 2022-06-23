package com.bank.bank.operation.persistance;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.bank.bank.operation.models.Operation;

public interface OperationDao {
    @Transactional
    void deleteById(int id);
    Operation saveOperation(Operation operation);
    Optional<Operation> findById( int idOperation);
    List<Operation> findAll();
}
