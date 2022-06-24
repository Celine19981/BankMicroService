package com.bank.bank.account.persistance;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.bank.bank.account.models.Account;
public interface AccountDao {
    @Transactional
    void deleteByIban(String iban);
    Account createAccount(Account account);
    Account updateAccount(Account account);
    Optional<Account> findByIban(String iban);
    List <Account> findAll();
}
