package com.example.demo.repository;



import com.example.demo.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 Optional<User> findByUsername(String username);  // Add this method to find a user by username
	}
