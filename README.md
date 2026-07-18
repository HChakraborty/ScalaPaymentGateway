# Scala Payment Gateway

A production-inspired backend project built with Scala 3 and the ZIO ecosystem to learn modern functional backend development by incrementally building a payment gateway.

The project focuses on understanding backend architecture, functional programming, and enterprise application design rather than simply integrating technologies.

---

## Features

- HTTP server built with ZIO HTTP
- Type-safe REST APIs using Tapir
- Automatic OpenAPI specification generation
- Interactive Swagger UI documentation
- Functional programming with ZIO
- JSON serialization using ZIO JSON
- Layered backend architecture
- In-memory payment repository
- Domain-driven service layer
- Typed domain error handling
- Health endpoint
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

The application starts an HTTP server on **localhost:8080**.

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
  "amount": 999.99
}
```

**Successful Response**

```json
{
  "paymentId": "e0dbb26f-4b4d-4f1d-9e94-f8d08f8b6b95",
  "merchantId": "merchant-001",
  "amount": 999.99,
  "status": "PENDING"
}
```

---

### GET /payments

Returns all payments.

---

### GET /payments/{paymentId}

Returns a payment by its ID.

---

### Error Response

Business errors return a structured response.

```json
{
  "code": "404",
  "message": "Payment Not Found"
}
```

---

## Swagger UI

Interactive API documentation is available at:

```
http://localhost:8080/docs
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
        In-Memory Repository
                     │
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
                │   ├── PaymentResponse.scala
                │   ├── PaymentError.scala
                │   └── ErrorResponse.scala
                │
                ├── service/
                │   └── PaymentService.scala
                │
                └── repository/
                    ├── PaymentRepository.scala
                    └── PaymentRepositoryLive.scala
```

---

## Current Architecture Flow

```
HTTP Request
      │
      ▼
PaymentRoutes
      │
      ▼
PaymentEndpoints
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
In-Memory Storage (ListBuffer)
```
