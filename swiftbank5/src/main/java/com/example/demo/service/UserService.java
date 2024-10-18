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
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

 // Create new user and generate account
    public User createUser(User user) {
        // Save the user first
        User savedUser = userRepository.save(user);

        // Generate a random 10-digit account number
        Random random = new Random();
        long accountNumber = 1000000000L + (long) (random.nextDouble() * 9000000000L);

        // Create and link an account to the user, ensuring the account type is the same as the user
        Account account = new Account();
        account.setAccountNumber(accountNumber);  // Set the generated account number
        account.setUser(savedUser);  // Link the account to the saved user
        account.setAccountType(user.getAccountType());  // Use the accountType from user
        account.setBalance(0.0);  // Initial balance can be set to 0 or customized

        // Save the account to the database
        accountRepository.save(account);

        return savedUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
