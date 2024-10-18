package com.example.demo.service;

import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.AccountRepository;
import com.example.demo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//Modified TransactionService
@Service
public class TransactionService {

 @Autowired
 private TransactionRepository transactionRepository;

 @Autowired
 private AccountRepository accountRepository;
 
//Get all transactions
 public List<Transaction> getAllTransactions() {
     return transactionRepository.findAll();
 }

 // Get transaction by ID
 public Optional<Transaction> getTransactionById(Long id) {
     return transactionRepository.findById(id);
 }

 // Create a unified transaction method
 public Transaction createTransaction(Transaction transaction) {
     Optional<Account> accountOpt = accountRepository.findById(transaction.getAccountId());

     if (accountOpt.isPresent()) {
         Account account = accountOpt.get();

         if (transaction.getTransactionType() == Transaction.TransactionType.DEPOSIT) {
             account.setBalance(account.getBalance() + transaction.getAmount());
         } else if (transaction.getTransactionType() == Transaction.TransactionType.WITHDRAWAL) {
             if (account.getBalance() >= transaction.getAmount()) {
                 account.setBalance(account.getBalance() - transaction.getAmount());
             } else {
                 throw new RuntimeException("Insufficient funds");
             }
         } else if (transaction.getTransactionType() == Transaction.TransactionType.TRANSFER) {
             if (transaction.getTransactionTo() == null) {
                 throw new RuntimeException("Transfer destination account is missing");
             }
             
             Optional<Account> toAccountOpt = accountRepository.findById(transaction.getTransactionTo());
             if (!toAccountOpt.isPresent()) {
                 throw new RuntimeException("Destination account not found");
             }

             Account toAccount = toAccountOpt.get();
             if (account.getBalance() >= transaction.getAmount()) {
                 account.setBalance(account.getBalance() - transaction.getAmount());
                 toAccount.setBalance(toAccount.getBalance() + transaction.getAmount());

                 accountRepository.save(toAccount); // Save updated destination account
             } else {
                 throw new RuntimeException("Insufficient funds for transfer");
             }
         } else {
             throw new RuntimeException("Invalid transaction type");
         }

         accountRepository.save(account); // Save updated account balance

         transaction.setTransactionDate(LocalDateTime.now()); // Set the transaction date
         return transactionRepository.save(transaction); // Save the transaction
     } else {
         throw new RuntimeException("Account not found");
     }
 }
}
