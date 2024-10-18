package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.User;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private UserRepository userRepository;

    public Account createAccount(Account account) {
        // Fetch the associated user
        Optional<User> userOptional = userRepository.findById(account.getUser().getUserId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Ensure the account type is the same as the user's account type
            account.setAccountType(user.getAccountType());

            // Generate random account number if not provided
            if (account.getAccountNumber() == null) {
                Random random = new Random();
                long accountNumber = 1000000000L + (long) (random.nextDouble() * 9000000000L);
                account.setAccountNumber(accountNumber);
            }

            // Save the account
            return accountRepository.save(account);
        } else {
            throw new RuntimeException("User not found.");
        }
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
