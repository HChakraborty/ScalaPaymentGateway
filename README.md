# Scala Payment Gateway

A production-inspired backend project built with **Scala 3** and the **ZIO ecosystem** to learn modern functional backend development by incrementally building a payment gateway.

The project focuses on understanding backend architecture, functional programming, dependency injection, and enterprise application design rather than simply integrating technologies.

---

## Features

- HTTP server built with ZIO HTTP
- Type-safe REST APIs using Tapir
- Automatic OpenAPI specification generation
- Interactive Swagger UI documentation
- Functional programming with ZIO
- Dependency Injection using ZLayer
- Repository pattern
- Domain-driven service layer
- Typed domain error handling
- JSON serialization using ZIO JSON
- Strongly typed domain models
- In-memory payment repository
- Health monitoring endpoint
- Payment management APIs

---

## Technology Stack

- Scala 3
- ZIO
- ZIO HTTP
- Tapir
- Swagger UI Bundle
- ZIO JSON
- JDK 21
- sbt

---

## Prerequisites

- JDK 21
- sbt

---

## Running the Project

```bash
sbt run
```

The application starts on:

```
http://localhost:8080
```

---

## Swagger UI

Interactive API documentation:

```
http://localhost:8080/docs
```

---

## Available Endpoints

### GET /health

Returns the current application status.

**Response**

```text
Scala Payment Gateway is running!
```

---

### POST /payments

Creates a new payment.

**Request**

```json
{
  "merchantId": "merchant-001",
  "amount": 999.99,
  "currency": "INR",
  "paymentMethod": "UPI"
}
```

**Response**

```json
{
  "paymentId": "e0dbb26f-4b4d-4f1d-9e94-f8d08f8b6b95",
  "merchantId": "merchant-001",
  "money": {
    "amount": 999.99,
    "currency": "INR"
  },
  "paymentMethod": "UPI",
  "status": "PENDING",
  "createdAt": "2026-07-20T10:15:30Z",
  "updatedAt": "2026-07-20T10:15:30Z"
}
```

---

### GET /payments

Returns all payments.

---

### GET /payments/{paymentId}

Returns a payment by its ID.

---

## Error Response

Business errors are returned as structured JSON.

```json
{
  "code": "404",
  "message": "Payment Not Found"
}
```

Example validation error:

```json
{
  "code": "400",
  "message": "Invalid Amount"
}
```

---

## Current Architecture

```
                  Client
                     │
             HTTP Request
                     │
        ┌────────────┴────────────┐
        │                         │
   Health API              Payment APIs
        │                         │
        └────────────┬────────────┘
                     │
             Tapir Endpoints
                     │
              Server Logic
                     │
              Payment Service
                     │
             Payment Repository
                     │
         PaymentRepositoryLive
                     │
          In-Memory ListBuffer
                     │
             HTTP Response
```

---

## Request Flow

```
HTTP Request
      │
      ▼
PaymentRoutes
      │
      ▼
PaymentService
      │
      ▼
PaymentRepository
      │
      ▼
PaymentRepositoryLive
      │
      ▼
ListBuffer (In-Memory Storage)
      │
      ▼
HTTP Response
```

---

## Current Project Structure

```
src/
└── main/
    └── scala/
        └── paymentgateway/
            ├── Main.scala
            │
            ├── infrastructure/
            │   └── http/
            │       └── HttpServer.scala
            │
            ├── health/
            │   └── api/
            │       └── HealthEndpoints.scala
            │
            └── payment/
                ├── api/
                │   ├── PaymentEndpoints.scala
                │   ├── PaymentRoutes.scala
                │   └── PaymentErrorMapper.scala
                │
                ├── model/
                │   ├── CreatePaymentRequest.scala
                │   ├── Currency.scala
                │   ├── ErrorResponse.scala
                │   ├── Money.scala
                │   ├── Payment.scala
                │   ├── PaymentError.scala
                │   ├── PaymentMethod.scala
                │   └── PaymentStatus.scala
                │
                ├── repository/
                │   ├── PaymentRepository.scala
                │   └── PaymentRepositoryLive.scala
                │
                └── service/
                    └── PaymentService.scala
```
