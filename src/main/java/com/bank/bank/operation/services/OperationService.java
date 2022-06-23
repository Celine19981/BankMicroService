package com.bank.bank.operation.services;

import java.util.List;
import java.util.Optional;

import com.bank.bank.operation.models.Operation;

public interface OperationService {
    void deleteById(int id);
    Operation saveOperation(Operation operation);
    Optional<Operation> findById( int idOperation);
    List<Operation> findAll();
}
