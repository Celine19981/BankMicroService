package com.bank.bank.operation.presentation;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bank.operation.models.Operation;
import com.bank.bank.operation.services.OperationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/operation")
@AllArgsConstructor
public class OperationApi {
    OperationService operationService;

    @GetMapping
    List<Operation> getAllOperation() {
        return operationService.findAll();
    }

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
