package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountService {
	

    @Autowired
    private AccountRepository accountRepository;  // Inject the AccountRepository
    

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();  // Retrieve all accounts from the repository
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);  // Retrieve account by ID
    }

    public Account createAccount(Account account) {
    	Random random = new Random();
        long accountNumber = 1000000000L + (long) (random.nextDouble() * 9000000000L);
        
        account.setAccountNumber(accountNumber); // Set the account number

        return accountRepository.save(account);  // Save the account with the generated number
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);  // Delete account by ID
    }
}
