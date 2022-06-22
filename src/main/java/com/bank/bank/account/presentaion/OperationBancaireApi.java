package com.bank.bank.account.presentaion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bank.account.models.OperationBancaire;
import com.bank.bank.account.persistance.OperationBancaireDao;

@RestController
@RequestMapping("/OperationBancaire")
public class OperationBancaireApi {
    @Autowired
   OperationBancaireDao operationBancaireDao;
   @GetMapping("/{idOperation}")
    OperationBancaire getOperationBancaire(@PathVariable(required = true) int idOperation) {
        OperationBancaire operationBancaire = operationBancaireDao.findByIdOperation(idOperation).orElse(null);
        return operationBancaire;
    }
    @PostMapping("/{iban}")

    OperationBancaire createOperationBancaire(@RequestBody OperationBancaire operationBancaire) {
        return operationBancaireDao.save(operationBancaire);
    }
    @GetMapping("/{iban}")
    void deleteByIdOperation(@PathVariable(required = true) int idOperation) {
        operationBancaireDao.deleteByIdOperation(idOperation);
    }
    @GetMapping("/{iban}")
    void updateOperationBancaire(@PathVariable(required = true) OperationBancaire operationBancaire){
        operationBancaireDao.update( operationBancaire);
    }
}
