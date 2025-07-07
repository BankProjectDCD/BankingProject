package com.example.bank.app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.bank.app.data.model.User1;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User1, Long> {
    Optional<User1> findByUsername(String username);
    Optional<User1> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
