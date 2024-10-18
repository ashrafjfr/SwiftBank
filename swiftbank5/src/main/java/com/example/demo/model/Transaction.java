package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Enumerated(EnumType.STRING)  // Use Enum for transactionType
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;  // Changed from String to TransactionType

    @Column(name = "transaction_to")
    private Long transactionTo;

    @Column(nullable = false)
    private Double amount;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    // Getters and Setters

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public TransactionType getTransactionType() {  // Enum getter
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {  // Enum setter
        this.transactionType = transactionType;
    }

    public Long getTransactionTo() {
        return transactionTo;
    }

    public void setTransactionTo(Long transactionTo) {
        this.transactionTo = transactionTo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public enum TransactionType {  // Enum defined inside Transaction class
        DEPOSIT,
        TRANSFER,
        WITHDRAWAL,
        
    }
}
