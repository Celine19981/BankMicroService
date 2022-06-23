package com.bank.bank.operation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bank.bank.operation.models.Operation;
import com.bank.bank.operation.persistance.OperationDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OperationServiceImpl implements OperationService {
    OperationDao operationDao;

    @Override
    public void deleteById(int id) {
        operationDao.deleteById(id);
    }

    @Override
    public Operation saveOperation(Operation operation) {
        return operationDao.saveOperation(operation);
    }

    @Override
    public Optional<Operation> findById(int id) {
        return operationDao.findById(id);
    }

    @Override
    public List<Operation> findAll() {
        return operationDao.findAll();
    }
    
}
