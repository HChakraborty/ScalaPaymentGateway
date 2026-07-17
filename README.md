# Scala Payment Gateway

A backend project built with Scala 3 and the ZIO ecosystem to learn and demonstrate modern backend development practices through a production-inspired payment gateway.

## Features

* HTTP server built with ZIO HTTP
* Root endpoint available at `/`
* Built with Scala 3
* Uses ZIO for effect management
* Uses sbt as the build tool

## Technology Stack

* Scala 3
* ZIO
* ZIO HTTP
* JDK 21
* sbt

## Prerequisites

* JDK 21
* sbt

## Running the Project

```bash
sbt run
```

The application starts an HTTP server on port `8080`.

## Available Endpoint

### GET /

Returns a simple response indicating that the application is running.

**Response**

```text
Scala Payment Gateway is running!
```

## Project Status

Current implementation includes:

* Project initialization
* ZIO application entry point
* ZIO HTTP server
* Root HTTP endpoint
