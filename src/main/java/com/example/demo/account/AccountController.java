package com.example.demo.account;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    AccountController(AccountRepository accountRepository) {this.accountRepository = accountRepository;}

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){return accountRepository.findAll();}

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account){return accountRepository.save(account);}

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable Integer id) {
        // Implement transaction retrieval logic
        // Return the transaction
        return accountRepository.findById(id).orElse(null); // Assuming you have a repository to retrieve transaction;
    }

    @DeleteMapping("/accounts/{id}")
    void deleteAccount(@PathVariable Integer id) {
        // Implement transaction deletion logic
        accountRepository.deleteById(id); // Assuming you have a repository to delete transaction;
    }

}
