package com.bank.bank.operation.persistance;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bank.bank.operation.models.Operation;

public interface OperationDao {
    @Transactional
    void deleteById(int id);
    Operation saveOperation(Operation operation);
    Optional<Operation> findById(int idOperation);
    Page<Operation> findAll(Pageable page);
}
