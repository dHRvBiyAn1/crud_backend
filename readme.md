# Spring Boot Student CRUD Backend

This repository provides a **basic Spring Boot CRUD API** for managing students, using **Java**, **Spring Boot**, **JPA (Hibernate)**, and **PostgreSQL**. It exposes RESTful endpoints for creating, reading, updating, and deleting student records, demonstrating best practices for building a backend service with these technologies.

## Features

- **CRUD Operations**: Create, Read, Update, Delete students.
- **JPA/Hibernate**: ORM interaction with PostgreSQL.
- **REST API**: JSON-based endpoints.
- **Validation**: Basic request validation.
- **Error Handling**: Standard error responses.

## Technologies

- Java 17 (or your preferred version)
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Maven

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/dHRvBiyAn1/crud_backend.git
cd crud_backend
```

### 2. Configure PostgreSQL

Create a database called `crud_backend` and update your `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/crud_backend
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build and Run

```bash
./mvnw spring-boot:run
```

The backend will run on `http://localhost:8080`.

## REST API Endpoints

| Method | Endpoint      | Description                |
|--------|---------------|----------------------------|
| GET    | /student      | Get all students           |
| GET    | /student/{id} | Get a student by ID        |
| POST   | /student      | Create a new student       |
| PUT    | /student/{id} | Update an existing student |
| DELETE | /student/{id} | Delete a student by ID     |

### Example Student JSON

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com"
}
```

## Project Structure

```
src/main/java/com/example/student
├── StudentCrudApplication.java
├── controller
│   └── StudentController.java
├── entity
│   └── Student.java
├── repository
│   └── StudentRepository.java
├── service
    └── StudentService.java
```

## License

This project is licensed under the MIT License.

## Notes

- Replace configurations and package names as per your setup.
- You can extend the Student entity with more fields and validations as needed.

Happy coding! 🚀