package com.example.demo.dto;

import com.example.demo.model.Transaction;

public class TransferDTO {

    private Long fromAccountId;
    private Long toAccountId;
    private Double amount;
    private Transaction.TransactionType transactionType;

    // Getters and setters
    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
