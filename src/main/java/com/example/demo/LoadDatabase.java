package com.example.demo;

import com.example.demo.account.Account;
import com.example.demo.account.AccountRepository;
import com.example.demo.transaction.Transaction;
import com.example.demo.transaction.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.transaction.TransactionType;
@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TransactionRepository transactionRepository, AccountRepository accountRepository) {

        return args -> {
            log.info("Preloading " + accountRepository.save(new Account("Nehir's Account", 40)));
            log.info("Preloading " + accountRepository.save(new Account("Leyre's Account", 60)));
            log.info("Preloading " + accountRepository.save(new Account("Joe's Account", 30)));
            log.info("Preloading " + accountRepository.save(new Account("Simon's Accounts", 20)));
            log.info("Preloading " + transactionRepository.save(new Transaction(1,TransactionType.DEPOSIT, 0)));
            log.info("Preloading " + transactionRepository.save(new Transaction(2,TransactionType.DEPOSIT, 0)));
        };
    }
}