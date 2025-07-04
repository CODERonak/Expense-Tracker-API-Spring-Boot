package com.code.ExpenseTrackerAPI.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.code.ExpenseTrackerAPI.entity.Users;
import com.code.ExpenseTrackerAPI.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // This method loads the user by username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // This checks if the user exists
        Users user = userRepository.findByUsername(username);

        // This throws an error if the user does not exist
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // This returns the user details
        return new CustomUserDetails(user);
    }
}