# Task Manager API

A RESTful API built with **Spring Boot** for managing tasks. This project demonstrates core backend development concepts including layered architecture, data persistence, validation, and exception handling.

## About This Project

This is my first Spring Boot API, developed as a learning project to understand backend development fundamentals. It showcases industry-standard practices and design patterns commonly used in enterprise Java applications.

## Tech Stack

- **Java 25**
- **Spring Boot 4.0.6**
- **Spring Data JPA** : Data persistence and repository pattern
- **Spring MVC** : RESTful web services
- **Jakarta Validation** : Request validation
- **PostgreSQL** : Relational database
- **Maven** : Dependency management and build tool

## Project Structure

```text
com.taskmanager.api
├── controller/       # REST API endpoints
├── dto/              # Data Transfer Objects (Request/Response)
├── entity/           # JPA entities
├── exception/        # Global exception handling
├── mapper/           # Entity-DTO mapping
├── repository/       # Data access layer
└── service/          # Business logic layer
```

## API Endpoints

| Method   | Endpoint      | Description             |
| -------- | ------------- | ----------------------- |
| `GET`    | `/tasks`      | Get all tasks           |
| `GET`    | `/tasks/{id}` | Get a task by ID        |
| `POST`   | `/tasks`      | Create a new task       |
| `PUT`    | `/tasks/{id}` | Update an existing task |
| `DELETE` | `/tasks/{id}` | Delete a task           |

### Request & Response Example

**Request body:**

```json
{
  "title": "Complete README",
  "description": "Write documentation for the project",
  "status": "IN_PROGRESS"
}
```

> Valid status values: `TODO`, `IN_PROGRESS`, `DONE`, `SUSPENDED`

**Response:**

```json
{
  "id": 1,
  "title": "Complete README",
  "description": "Write documentation for the project",
  "status": "IN_PROGRESS"
}
```


## Getting Started

### Prerequisites

- Java 25 or higher
- PostgreSQL
- Maven (or use the included Maven Wrapper)

### Installation

1. Clone the repository:

```bash
git clone https://github.com/Yaman-V/task-manager-api.git
cd task-manager-api
```

2. Create a PostgreSQL database named `task_manager`.

3. Set the environment variables:

```bash
export DB_USERNAME=your_username
export DB_PASSWORD=your_password
```

Example `application.properties` configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/task_manager
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
```

4. Run the application:

```bash
./mvnw spring-boot:run
```

Or using Maven directly:

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

## What I Learned

- Building RESTful APIs with Spring Boot
- Implementing layered architecture (Controller → Service → Repository)
- Data persistence with Spring Data JPA and PostgreSQL
- Using DTOs to separate API contracts from domain models
- Input validation with Jakarta Bean Validation
- Global exception handling with `@RestControllerAdvice`
- Dependency injection and Spring's IoC container

## License

MIT License, see [LICENSE](LICENSE) for details.

---

Built with ☕ and Spring Boot.
