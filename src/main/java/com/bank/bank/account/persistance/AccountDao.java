package com.bank.bank.account.persistance;

import java.util.List;
import java.util.Optional;

import com.bank.bank.account.models.Account;

public interface AccountDao {
    void deleteByIban(String iban);
    Account save(Account account);
    void update(Account account, String accountType, double interest, double expenses);
    Optional<Account> findByIban(String iban);
    List <Account> findAll();
}
