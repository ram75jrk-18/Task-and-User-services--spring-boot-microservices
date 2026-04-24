# Week 5 Microservices Architecture Diagram

```mermaid
flowchart LR
    Client[Postman / Browser]

    Client -->|REST API| UserService[User Service\nSpring Boot\nPort 8081]
    Client -->|REST API| TaskService[Task Service\nSpring Boot\nPort 8082]

    TaskService -->|REST Call using RestTemplate| UserService

    UserService --> UserData[(In-Memory User Data)]
    TaskService --> TaskData[(In-Memory Task Data)]
```

## Explanation
- User Service manages users.
- Task Service manages tasks.
- Task Service communicates with User Service using REST calls.
- Both services are independent Spring Boot applications.
