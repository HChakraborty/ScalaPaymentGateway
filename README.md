# Scala Payment Gateway

A production-inspired backend project built with Scala 3 and the ZIO ecosystem to learn modern functional backend development by incrementally building a payment gateway.

The project focuses on understanding backend architecture, functional programming, and enterprise application design rather than simply integrating technologies.

---

## Features

- HTTP server built with ZIO HTTP
- Type-safe API endpoint definition using Tapir
- Health endpoint available at `/health`
- Functional programming with ZIO
- Modular project structure for future expansion

---

## Technology Stack

- Scala 3
- ZIO
- ZIO HTTP
- Tapir
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

## Available Endpoint

### GET /health

Returns the current application status.

**Response**

```text
Scala Payment Gateway is running!
```

---

## Current Architecture

```
Browser
    │
GET /health
    │
    ▼
Tapir Endpoint Definition
    │
    ▼
Server Logic
    │
    ▼
ZioHttpInterpreter
    │
    ▼
ZIO HTTP Server
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
            └── health/
                └── api/
                    └── HealthEndpoints.scala
```

---

## Current Progress

### Completed

- Project initialization
- ZIO application entry point
- ZIO HTTP server
- Tapir endpoint definition
- Health endpoint
- Tapir → ZIO HTTP integration