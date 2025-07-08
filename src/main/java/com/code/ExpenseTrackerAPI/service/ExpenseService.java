package com.code.ExpenseTrackerAPI.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.code.ExpenseTrackerAPI.entity.*;
import com.code.ExpenseTrackerAPI.repository.*;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    private Users getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return userRepository.findByUsername(username);
    }

    // This method creates a new expense
    public void createExpense(Expense expense) {
        Users user = getCurrentUser();
        expense.setUser(user);
        expenseRepository.save(expense);
    }

    // This method lists all the expenses
    public List<Expense> listAllExpenses() {
        Users user = getCurrentUser();
        return expenseRepository.findByUser(user);
    }
}