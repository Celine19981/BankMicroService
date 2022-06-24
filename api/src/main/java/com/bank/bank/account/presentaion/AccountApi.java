package com.bank.bank.account.presentaion;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bank.account.models.Account;
import com.bank.bank.account.services.AccountService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountApi {
    AccountService accountService;

    @GetMapping
    List<Account> getAllAccounts() {
        return accountService.findAll();
    }

    @GetMapping("/{iban}")
    Optional<Account> getAccount(@PathVariable(required = true) String iban) {
        return accountService.findByIban(iban);
    }

    @PostMapping
    Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }
    @DeleteMapping("/{iban}")
    void deleteAccount(@PathVariable(required = true) String iban) {
        accountService.deleteByIban(iban);
    }
}
