package com.code.ExpenseTrackerAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.ExpenseTrackerAPI.entity.Expense;
import com.code.ExpenseTrackerAPI.entity.Users;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // This method lists all the expenses by user
    List<Expense> findByUser(Users user);
    Optional<Expense> findByIdAndUser(Long id, Users user);
}