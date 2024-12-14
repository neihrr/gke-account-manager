package com.example.demo.transaction;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    Integer transactionId;
    private Integer accountId; // ID of the associated account
    private TransactionType type; // Enum: DEPOSIT or WITHDRAWAL
    private Float amount; // Monetary value of the transaction
    private LocalDateTime timestamp; // Timestamp of the transaction
    private TransactionStatus status; // Enum: PENDING, COMPLETED, FAILED

    // Constructors, getters, setters, etc.

    // No-arg constructor required by JPA
    public Transaction() {
        // This constructor is intentionally left empty.
    }

    public Transaction(Integer accountId, TransactionType type, Float amount, String description) {
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.status = TransactionStatus.PENDING; // Default status
    }

    // Getters and Setters (or use Lombok for brevity)
    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
