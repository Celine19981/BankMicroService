package com.bank.bank.operation.presentation;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    Page<Operation> getAllOperation(@PageableDefault(page = 0, size = 20) Pageable page) {
        return operationService.findAll(page);
    }

    @GetMapping("/{id}")
    Optional<Operation> getOperation(@PathVariable(required = true) int id) {
        return operationService.findById(id);
    }

/*
    @GetMapping("/{destination}")
    Optional<Operation> getOperation(@PathVariable(required = true) Account destination) {
        return operationService.findByDestination(destination);
    }

     */
    @PostMapping
    Operation createOperation(@RequestBody Operation operation) {
        return operationService.saveOperation(operation);
    }


    @DeleteMapping("/{id}")
    void deleteOperation(@PathVariable(required = true) int id) {
        operationService.deleteById(id);
    }


}
