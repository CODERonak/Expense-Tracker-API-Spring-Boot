package com.code.ExpenseTrackerAPI.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.code.ExpenseTrackerAPI.entity.Users;
import com.code.ExpenseTrackerAPI.exceptions.custom.*;
import com.code.ExpenseTrackerAPI.repository.UserRepository;

@Service
public class AuthService {
    // This registers a new user
    private final UserRepository userRepository;
    // This encodes the password
    private final BCryptPasswordEncoder passwordEncoder;

    // This is the constructor
    public AuthService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // This method registers a new user
    public void registerUser(Users user) {
        // this checks if the username or email already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }

        // this checks if the email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        // this encodes the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void LoginUser(Users user) {
        // This checks if the user exists
        Users existingUser = userRepository.findByUsername(user.getUsername());

        // This throws an error if the username or password does not exist or is wrong
        if (existingUser == null ||
                !passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {

            throw new InvalidCredentialsException("Invalid username or password");
        }
    }
}