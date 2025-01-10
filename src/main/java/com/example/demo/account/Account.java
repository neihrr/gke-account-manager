package com.example.demo.account;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.util.Random;

@Entity
public class Account {
    @Id
    @GeneratedValue
    Integer id;
    private String name;
    private String accountNumber;
    private double balance;



    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Account() {
    }

    @PrePersist
    private void generateAccountNumberIfNeeded() {
        if (this.accountNumber == null || this.accountNumber.isEmpty()) {
            this.accountNumber = generateAccountNumber();
        }
    }
    private String generateAccountNumber() {
        System.out.println("Account number printed");
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            accountNumber.append(random.nextInt(10)); // Append a random digit (0-9)
        }
        System.out.println("accountNumber:"+accountNumber);
        return accountNumber.toString();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

