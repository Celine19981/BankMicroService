package com.bank.bank.account.persistance;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bank.account.models.Account;

@Repository
public interface DataJpaAccountDao extends AccountDao, JpaRepository<Account, String> {
    @Override
    default Account createAccount(Account account) {
        while (true) {
            String iban = "FR76" + RandomStringUtils.randomNumeric(23);
            ;
            if (findByIban(iban).isEmpty()) {
                account.setIban(iban);
                return save(account);
            }
        }
    }

    @Override
    default Account updateAccount(Account account) {
        if (findByIban(account.getIban()).isEmpty()) {
            throw new IllegalArgumentException("Account with iban: " + account.getIban() + " already exists");
        }
        return save(account);
    }
}
