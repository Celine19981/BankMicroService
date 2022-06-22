package com.bank.bank.account.presentaion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bank.account.models.Account;
import com.bank.bank.account.persistance.AccountDao;

@RestController
@RequestMapping("/account")
public class AccountApi {
    @Autowired
    AccountDao accountDao;

    @GetMapping("/{iban}")
    Account getAccount(@PathVariable(required = true) String iban) {
        Account account = accountDao.findByIban(iban).orElse(null);
        return account;
    }
    @PostMapping("/{iban}")

    Account createAccount(@RequestBody Account account) {
        return accountDao.save(account);
    }
    @GetMapping("/{iban}")
    void deleteAccount(@PathVariable(required = true) String iban) {
        accountDao.deleteByIban(iban);
    }
    @GetMapping("/{iban}")
    void updateAccount(@PathVariable(required = true) String iban,@PathVariable(required = true) String accountType,@PathVariable(required = true) double interest,@PathVariable(required = true) double expenses){
        Account account=getAccount(iban);
        accountDao.update( account,  accountType, interest, expenses);
    }
}
