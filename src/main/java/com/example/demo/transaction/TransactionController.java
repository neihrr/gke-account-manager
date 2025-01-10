package com.example.demo.transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    private final TransactionRepository repository;
    private final TransactionService transactionService;

    TransactionController(TransactionRepository repository,TransactionService transactionService) {
        this.repository = repository;
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        // Implement transaction creation logic
        // Return the created transaction
        return repository.save(transaction); // Assuming you have a repository to save transaction;
    }

    @PostMapping("transactions/process/{accountId}")
    public Transaction processTransaction(
            @PathVariable Integer accountId,
            @RequestBody TransactionRequest request) {
        return transactionService.processTransaction(
                accountId,
                request.getType(),
                request.getAmount()
        );
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

    @GetMapping("/transactions/account/{accountId}")
    public List<Transaction> getTransactionsByAccountId(@PathVariable Integer accountId) {
        return repository.findByAccountId(accountId);
    }

    @DeleteMapping("/transactions/{id}")
    void deleteTransaction(@PathVariable Integer id) {
        repository.deleteById(id); // Assuming you have a repository to delete transaction;
    }
}