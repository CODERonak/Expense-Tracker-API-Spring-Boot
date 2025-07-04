package com.code.ExpenseTrackerAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    // This method returns a test page
    @GetMapping("/test")
    public String test() {
        return "This is a test page";
    }

}