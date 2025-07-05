package com.code.ExpenseTrackerAPI.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.code.ExpenseTrackerAPI.entity.Users;
import com.code.ExpenseTrackerAPI.service.AuthService;

// This controller registers a new user
@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // This method registers a new user
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user) {
        // This checks if the username or email already exists
        authService.registerUser(user);
        // This returns a success message
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    // This method logs in a user
    // login is automatic in the spring security 
    // so this method wlll just show the message plus handle the exception
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
        authService.LoginUser(user);
        return ResponseEntity.ok("User logged in successfully!");
    }
}