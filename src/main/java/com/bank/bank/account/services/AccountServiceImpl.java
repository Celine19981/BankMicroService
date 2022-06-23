package com.bank.bank.account.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bank.bank.account.models.Account;
import com.bank.bank.account.persistance.AccountDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    AccountDao accountDao;

    @Override
    public void deleteByIban(String iban) {
        accountDao.deleteByIban(iban);
    }

    @Override
    public Account createAccount(Account account) {
        return accountDao.createAccount(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return updateAccount(account);
    }

    @Override
    public Optional<Account> findByIban(String iban) {
        return accountDao.findByIban(iban);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
