
package com.example.demo.transaction;

import com.example.demo.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.account.AccountRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository ;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    /**
     * Processes a transaction for an account.
     *
     * @param accountId the ID of the account
     * @param type the type of transaction (DEPOSIT or WITHDRAWAL)
     * @param amount the amount to be transacted
     * @return the created Transaction object
     */
    public Transaction processTransaction(Integer accountId, TransactionType type, double amount) {
        // Validate account existence
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if (optionalAccount.isEmpty()) {
            throw new IllegalArgumentException("Account with ID " + accountId + " does not exist.");
        }

        Account account = optionalAccount.get();

        // Handle business logic
        if (type == TransactionType.WITHDRAWAL && account.getBalance() < amount) {
            throw new IllegalArgumentException("Inal.");
        }

        if(type == TransactionType.DEPOSIT){
            account.setBalance(account.getBalance() + amount);
        }
        else{
            account.setBalance(account.getBalance() - amount);
        }
        // Update account balance
        accountRepository.save(account);

        // Create and save transaction
        Transaction transaction = new Transaction(accountId, type, amount);
        transaction.setTimestamp(LocalDateTime.now());
        System.out.println("Transaction: "+transaction.toString()+" type: "+type+" amount: "+amount);
        transaction.setStatus(TransactionStatus.COMPLETED);

        transactionRepository.save(transaction);

        return transaction;
    }

    /**
     * Retrieves all transactions for a given account.
     *
     * @param accountId the ID of the account
     * @return a list of Transaction objects
     */
    public List<Transaction> getTransactionsByAccount(Integer accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}
