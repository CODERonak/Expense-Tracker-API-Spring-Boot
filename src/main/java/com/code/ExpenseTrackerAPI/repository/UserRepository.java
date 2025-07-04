package com.code.ExpenseTrackerAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.ExpenseTrackerAPI.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    // This method finds the user by username
    Users findByUsername(String username);
}