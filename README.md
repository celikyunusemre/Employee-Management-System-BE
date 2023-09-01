## Employee Management System Backend

---

This Employee Management System Backend is a simple yet robust application developed using Java 17 and Spring Boot 3.1.1, designed exclusively for backend operations.
It provides essential CRUD (Create, Read, Update, Delete) functionality for managing employee data.
The system employs NoSQL with JPA Hibernate for data storage and retrieval, ensuring data persistence and scalability.

### Features:
* **RESTful Endpoints:** Basic endpoints for adding, deleting, updating, and retrieving employee data.
* **Exception Handling:** A custom exception handler to gracefully handle errors and exceptions.
* **Simplified Backend:** Ideal for projects that require a minimalistic backend for employee data management.

### Tech Stack:
* **Java 17**
* **Spring Boot 3.1.1:** A lightweight framework for building Java applications.
* **Spring Data JPA:** Simplifies data access and persistence with JPA Hibernate.
* **Exception Handling:** Custom exception handling to manage errors gracefully.

### Endpoints:
* **Get all employees:** `GET localhost:8080/api/employee`
* **Get employee by id:** `GET localhost:8080/api/employee/:id`
* **Get employees pagination:** `GET localhost:8080/api/employee?page=0&size=3&sortby=identityNo`
  * **page:**: (Required) int
  * **size:** (Optional) int | 50 by default
  * ***sortby:** (Optional) string | identityNo by default
* **Get all positions:** `GET localhost:8080/api/employee/positions`
* **Get all departments:** `GET localhost:8080/api/employee/departments`
* **Update employee by id:** `UPDATE localhost:8080/api/employee/:id`
* **Delete employee by id:** `DELETE localhost:8080/api/employee/:id`
* **Add new employee:** `POST localhost:8080/api/employee/`

*Postman Collection: [Click me](./EMS-System.postman_collection.json)*

### Getting Started:

1. Clone this repository to your local machine.
2. Configure settings in the *application.properties* file.
3. Build and run the application using Maven or your preferred IDE.
4. Access the API using the provided endpoints for CRUD operations. (by default **localhost:8080/api**)

### License:
This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.

### Disclaimer:
This system is intended for educational and demonstration purposes and represents a minimalistic approach to employee data management. Ensure that you adapt and expand the system according to your specific project requirements.

