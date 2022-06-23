package com.bank.bank.operation.presentation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bank.operation.models.Operation;
import com.bank.bank.operation.services.OperationService;

@RestController
@RequestMapping("/operation")
public class OperationApi {
    @Autowired
    OperationService operationService;

    @GetMapping("/{id}")
    Optional<Operation> getOperation(@PathVariable(required = true) int id) {
        return operationService.findById(id);
    }

    @PostMapping
    Operation createOperation(@RequestBody Operation operation) {
        return operationService.saveOperation(operation);
    }


    @DeleteMapping("/{id}")
    void deleteOperation(@PathVariable(required = true) int id) {
        operationService.deleteById(id);
    }
}
