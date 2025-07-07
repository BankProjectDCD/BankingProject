package com.example.bank.app.data.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.bank.app.data.model.Account;
import com.example.bank.app.data.model.Transaction;
import com.example.bank.app.data.payload.request.TransactionRequest;
import com.example.bank.app.data.payload.response.TransactionResponse;
import com.example.bank.app.data.repository.AccountRepository;
import com.example.bank.app.data.repository.TransactionRepository;
import com.example.bank.app.data.security.UserDetailsImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionController(TransactionRepository transactionRepository, 
                               AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public TransactionResponse createTransaction(@RequestBody TransactionRequest transactionRequest,
                                               Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Account account = accountRepository.findByAccountNumber(transactionRequest.getAccountNumber())
                .orElseThrow(() -> new RuntimeException("Error: Account not found."));

        if (!account.getUser().getId().equals(userDetails.getId())) {
            throw new RuntimeException("Error: Unauthorized access to account.");
        }

        // Update account balance
        BigDecimal newBalance;
        if ("DEPOSIT".equalsIgnoreCase(transactionRequest.getTransactionType())) {
            newBalance = account.getBalance().add(transactionRequest.getAmount());
        } else if ("WITHDRAWAL".equalsIgnoreCase(transactionRequest.getTransactionType())) {
            if (account.getBalance().compareTo(transactionRequest.getAmount()) < 0) {
                throw new RuntimeException("Error: Insufficient funds.");
            }
            newBalance = account.getBalance().subtract(transactionRequest.getAmount());
        } else {
            throw new RuntimeException("Error: Invalid transaction type.");
        }

        account.setBalance(newBalance);
        accountRepository.save(account);

        // Create transaction
        Transaction transaction = new Transaction();
        transaction.setTransactionId(generateTransactionId());
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setTransactionType(transactionRequest.getTransactionType());
        transaction.setDescription(transactionRequest.getDescription());
        transaction.setAccount(account);

        Transaction savedTransaction = transactionRepository.save(transaction);

        return new TransactionResponse(
                savedTransaction.getId(),
                savedTransaction.getTransactionId(),
                savedTransaction.getAmount(),
                savedTransaction.getTransactionType(),
                savedTransaction.getDescription(),
                savedTransaction.getCreatedAt());
    }

    @GetMapping("/{accountNumber}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<TransactionResponse> getAccountTransactions(@PathVariable String accountNumber,
                                                         Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Error: Account not found."));

        if (!account.getUser().getId().equals(userDetails.getId())) {
            throw new RuntimeException("Error: Unauthorized access to account.");
        }

        return transactionRepository.findByAccount(account).stream()
                .map(transaction -> new TransactionResponse(
                        transaction.getId(),
                        transaction.getTransactionId(),
                        transaction.getAmount(),
                        transaction.getTransactionType(),
                        transaction.getDescription(),
                        transaction.getCreatedAt()))
                .collect(Collectors.toList());
    }

    private String generateTransactionId() {
        return "TXN" + UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }
}
