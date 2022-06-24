package com.bank.bank.operation.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bank.bank.operation.models.Operation;

public interface OperationService {
    void deleteById(int id);
    Operation saveOperation(Operation operation);
    Optional<Operation> findById( int idOperation);
    Page<Operation> findAll(Pageable page);
}
