package com.code.ExpenseTrackerAPI.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
// This entity shows the users table with the following id, username, password, email
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The username should be unique
    @Column(unique = true) 
    private String username;
    private String password;

    // The email should be unique
    @Column(unique = true)
    private String email;
}