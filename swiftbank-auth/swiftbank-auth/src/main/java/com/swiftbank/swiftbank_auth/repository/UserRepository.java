package com.swiftbank.swiftbank_auth.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.swiftbank.swiftbank_auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}