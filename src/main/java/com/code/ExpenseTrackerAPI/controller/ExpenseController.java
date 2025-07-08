package com.code.ExpenseTrackerAPI.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.code.ExpenseTrackerAPI.entity.Expense;
import com.code.ExpenseTrackerAPI.service.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // This method creates a new category
    @PostMapping("/add")
    public ResponseEntity<String> registerUser(@RequestBody Expense expense) {
        expenseService.createExpense(expense);
        return new ResponseEntity<>("Expense created successfully", HttpStatus.CREATED);
    }

    // This method lists all the categories
    @GetMapping("/list")
    public ResponseEntity<List<Expense>> listAllExpenses() {
        List<Expense> expenses = expenseService.listAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    // This method updates the category by id
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        expenseService.updateExpense(id, expense);
        return new ResponseEntity<>("Expense updated successfully", HttpStatus.OK);
    }

    // this method deletes the expense by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return new ResponseEntity<>("Expense deleted successfully", HttpStatus.NO_CONTENT);
    }
}