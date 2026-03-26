
Student Management System API

A Spring Boot based REST API for managing student data with authentication and authorization using JWT.


Features

-  User Authentication (Register & Login)
-  JWT-based Authorization
-  CRUD Operations on Students
-  Input Validation
-  Global Exception Handling
-  Layered Architecture (Controller, Service, Repository)
-  DTO Pattern for secure data transfer
-  Custom API Response structure

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT (JSON Web Token)
- MySQL
- Maven
- Postman (for testing)

---

##  Project Structure
com.example.student │ ├── controller       # REST Controllers ├── service          # Business Logic ├── repository       # JPA Repositories ├── model            # Entity Classes ├── dto              # Data Transfer Objects ├── security         # JWT & Security Config ├── util             # Utility classes (JwtUtil) ├── exception        # Global Exception Handling
Copy code

---

##  Authentication APIs

### 🟢 Register User

POST `/auth/register`

```json
{
  "username": "arun",
  "password": "1234"
}
 Login User
POST /auth/login
JSON
Copy code
{
  "username": "arun",
  "password": "1234"
}
Returns JWT Token
Student APIs (Protected)
 Add this header:
Copy code

Authorization: Bearer <your_token>
 Create Student
POST /students
JSON
Copy code
{
  "name": "Arun",
  "age": 22,
  "course": "Java",
  "marks": 85
}
 Get All Students
GET /students
🔍 Get Student by ID
GET /students/{id}
 Update Student
PUT /students/{id}
 Delete Student
DELETE /students/{id}
 Database Configuration
Update in application.properties:
Copy code

spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
 How to Run
-Clone the project
-Open in IntelliJ
-Configure MySQL database
-Run StudentApplication.java
-Use Postman to test APIs
 Notes
JWT token is required for all student APIs
Validation errors are handled globally
Proper layered architecture
