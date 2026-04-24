# Week 5 Submission - Task Management Microservices

## Objective
Break the previous Task Management System into simple microservices using Spring Boot.

## Microservices Created
1. User Service
2. Task Service

## GitHub Repositories to Create
Create two separate repositories:

### Repository 1
Name: user-service
Description: Spring Boot microservice for managing users in Task Management System.
Upload the full `user-service` folder.

### Repository 2
Name: task-service
Description: Spring Boot microservice for managing tasks and calling User Service.
Upload the full `task-service` folder.

## How to Run

### Run User Service
```bash
cd user-service
mvn spring-boot:run
```
User Service runs on:
```text
http://localhost:8081
```

### Run Task Service
Open another terminal:
```bash
cd task-service
mvn spring-boot:run
```
Task Service runs on:
```text
http://localhost:8082
```

## API Endpoints

### User Service APIs
```text
GET  http://localhost:8081/api/users
GET  http://localhost:8081/api/users/1
POST http://localhost:8081/api/users
```

Sample POST body:
```json
{
  "name": "Alex User",
  "email": "alex@example.com",
  "role": "USER"
}
```

### Task Service APIs
```text
GET  http://localhost:8082/api/tasks
GET  http://localhost:8082/api/tasks/1
POST http://localhost:8082/api/tasks
GET  http://localhost:8082/api/tasks/1/user
```

Sample POST body:
```json
{
  "title": "Test Microservice API",
  "description": "Check service communication",
  "status": "PENDING",
  "assignedUserId": 1
}
```

## Service Communication
Task Service calls User Service using REST API:
```text
GET http://localhost:8081/api/users/{id}
```

## Deliverables Checklist
- Separate GitHub repository for User Service
- Separate GitHub repository for Task Service
- Working REST APIs for both services
- Architecture diagram added
- Clean code and proper service separation
