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
            log.info("Preloading " + accountRepository.save(new Account("wihuuu", 50)));
            log.info("Preloading " + transactionRepository.save(new Transaction(1,TransactionType.DEPOSIT, 40)));
            log.info("Preloading " + transactionRepository.save(new Transaction(2,TransactionType.DEPOSIT, 60)));
        };
    }
}