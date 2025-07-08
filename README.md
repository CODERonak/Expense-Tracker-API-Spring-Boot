💸 Expense Tracker API (Spring Boot)
A secure, role-based REST API for tracking personal expense, built using Spring Boot. This project supports basic user authentication, expense and category management. 

It's the last beginner level project. Next one is foing to be a intermediate level. 

Also as it'a beginner level project i might be missing few features

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
POST /register	Register new user
POST /login	    Login 

CategoryController
GET	/category	Get all category
POST	/category	Create new category
PUT	/category/{id}	Update category
DELETE	/category/{id}	Delete category

ExpenseController
GET	/expense	Get all expenses for user
POST /expense	Create new expense
PUT	/expense/{id}	Update expense
DELETE	/expense/{id}	Delete expense