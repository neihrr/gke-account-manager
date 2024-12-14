package com.example.demo.transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    private final TransactionRepository repository;

    TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/transactions")
    public Transaction newTransaction(@RequestBody Transaction transaction) {
        // Implement transaction creation logic
        // Return the created transaction
        return repository.save(transaction); // Assuming you have a repository to save transaction;
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        // Retrieve all transactions from the database
        return repository.findAll();
    }

    @GetMapping("/transactions/{id}")
    public Transaction getTransaction(@PathVariable Integer id) {
        // Implement transaction retrieval logic
        // Return the transaction
        return repository.findById(id).orElse(null); // Assuming you have a repository to retrieve transaction;
    }   

    @DeleteMapping
    void deleteTransaction(@PathVariable Integer id) {
        // Implement transaction deletion logic
        repository.deleteById(id); // Assuming you have a repository to delete transaction;
    }
}