# 💸 Expense Tracker API (Spring Boot)

A secure, role-based REST API for tracking personal expenses, built with **Spring Boot**. This project supports basic user authentication, and expense and category management.

> 🧑‍💻 This is my **last beginner-level project**. The next one will be **intermediate-level**.
> ⚠️ As a beginner project, some features might be missing or simplified.

---

## ✅ Features

* User registration and login
* Manage expenses and categories
* Secure endpoints using Spring Security
* MySQL for data persistence

---

## 📁 Project Structure

```
src/
└── main/
    ├── java/
    │   └── com.example.expensetracker/
    │       ├── controller/      # REST controllers
    │       ├── entity/          # JPA entities
    │       ├── repository/      # Spring Data JPA repositories
    │       ├── service/         # Business logic
    │       └── config/          # Spring Security and other configurations
    └── resources/
        └── application.properties
```

---

## 🔧 Technologies Used

* Java 17+
* Spring Boot
* Spring Web
* Spring Security
* Spring Data JPA
* MySQL
* Lombok
* Spring Boot DevTools

---

## 🌐 API Endpoints

### 🔐 AuthController

| Method | Endpoint    | Description       |
| ------ | ----------- | ----------------- |
| POST   | `/register` | Register new user |
| POST   | `/login`    | Login user        |

### 📁 CategoryController

| Method | Endpoint         | Description         |
| ------ | ---------------- | ------------------- |
| GET    | `/category`      | Get all categories  |
| POST   | `/category`      | Create new category |
| PUT    | `/category/{id}` | Update category     |
| DELETE | `/category/{id}` | Delete category     |

### 💰 ExpenseController

| Method | Endpoint        | Description           |
| ------ | --------------- | --------------------- |
| GET    | `/expense`      | Get all user expenses |
| POST   | `/expense`      | Create new expense    |
| PUT    | `/expense/{id}` | Update expense        |
| DELETE | `/expense/{id}` | Delete expense        |
