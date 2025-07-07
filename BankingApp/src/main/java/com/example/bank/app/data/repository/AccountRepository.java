package com.example.bank.app.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.bank.app.data.model.Account;
import com.example.bank.app.data.model.User1;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(String accountNumber);
    List<Account> findByUser(User1 user);
    boolean existsByAccountNumber(String accountNumber);
}