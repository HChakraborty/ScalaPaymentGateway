# Scala Payment Gateway

A production-inspired backend project built with Scala 3 and the ZIO ecosystem to learn modern functional backend development by incrementally building a payment gateway.

The project focuses on understanding backend architecture, functional programming, and enterprise application design rather than simply integrating technologies.

---

## Features

- HTTP server built with ZIO HTTP
- Type-safe REST APIs using Tapir
- Automatic OpenAPI specification generation
- Interactive Swagger UI documentation
- Health endpoint
- Payment creation endpoint
- JSON request and response models using ZIO JSON
- Functional programming with ZIO
- Modular project structure for future expansion

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

The application starts an HTTP server on port **8080**.

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

**Response**

```json
{
  "paymentId": "e0dbb26f-4b4d-4f1d-9e94-f8d08f8b6b95",
  "merchantId": "merchant-001",
  "amount": 999.99,
  "status": "PENDING"
}
```

---

### Swagger UI

Interactive API documentation is available at:

```
http://localhost:8080/docs
```

---

## Current Architecture

```
                  Browser
                     │
        ┌────────────┴────────────┐
        │                         │
   GET /health             POST /payments
        │                         │
        └────────────┬────────────┘
                     │
             Tapir Endpoint
                     │
              Server Logic
                     │
         ZioHttpInterpreter
                     │
             ZIO HTTP Server
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
                │   └── PaymentEndpoints.scala
                │
                └── model/
                    ├── CreatePaymentRequest.scala
                    └── PaymentResponse.scala
```

