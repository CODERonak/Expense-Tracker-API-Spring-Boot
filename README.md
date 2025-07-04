💸 Expense Tracker API (Spring Boot)
A secure, role-based REST API for tracking personal expenses, built using Spring Boot. This project supports basic user authentication, expense and category management, and includes optional enhancements like JWT authentication and analytics.

✅ Features
User registration & login

Manage expenses and categories

Secure endpoints using Spring Security

Using MySql Database

Project structure -

src/
└── main/
    ├── java/
    │   └── com.example.expensetracker/
    │       ├── controller/      
    │       ├── entity/         
    │       ├── repository/     
    │       ├── service/        
    │       └── config/          
    └── resources/
        └── application.properties


🔧 Technologies Used
Java 17+

Spring Boot

Spring Web

Spring Security

Spring Data JPA

MySQL

Lombok

Spring Boot DevTools

🌐 API Endpoints
AuthController
Method	Endpoint	Description
POST	/register	Register new user
POST	/login	    Login 

Still on progress!