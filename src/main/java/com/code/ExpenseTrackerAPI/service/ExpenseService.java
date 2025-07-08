package com.code.ExpenseTrackerAPI.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.code.ExpenseTrackerAPI.entity.*;
import com.code.ExpenseTrackerAPI.repository.*;

@Service
public class ExpenseService {
    // This service handles the expenses
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    // This method gets the current user
    private Users getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return userRepository.findByUsername(username);
    }

    // This method creates a new expense
    public void createExpense(Expense expense) {
        // This gets the current user
        Users user = getCurrentUser();
        expense.setUser(user);
        expenseRepository.save(expense);
    }

    // This method lists all the expenses
    public List<Expense> listAllExpenses() {
        // This gets the current user
        Users user = getCurrentUser();
        return expenseRepository.findByUser(user);
    }

    // This method updates the expense by id
    public void updateExpense(Long id, Expense expense) {
        // This gets the current user
        Users user = getCurrentUser();
        expense.setId(id);
        expense.setUser(user);
        expenseRepository.save(expense);
    }

    // This method deletes the expense by id
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}