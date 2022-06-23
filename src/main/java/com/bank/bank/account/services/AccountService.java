package com.bank.bank.account.services;

import java.util.List;
import java.util.Optional;

import com.bank.bank.account.models.Account;

public interface AccountService {
    void deleteByIban(String iban);
    Account createAccount(Account account);
    Account updateAccount(Account account);
    Optional<Account> findByIban(String iban);
    List<Account> findAll();
}
