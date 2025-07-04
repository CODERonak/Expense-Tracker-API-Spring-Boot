package com.code.ExpenseTrackerAPI.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.ExpenseTrackerAPI.entity.Category;
// import com.code.ExpenseTrackerAPI.entity.Users;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // This method finds the categories by owner
    // List<Category> findByOwner(Users owner);
}