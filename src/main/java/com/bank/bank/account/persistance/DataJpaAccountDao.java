package com.bank.bank.account.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bank.account.models.Account;

@Repository
public interface DataJpaAccountDao extends AccountDao, JpaRepository<Account, String> {

}
