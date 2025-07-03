package com.code.ExpenseTrackerAPI.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
// This entity shows the categories table with id and name
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The name of the category should be unique
    @Column(unique = true) 
    private String name;
}