# Casino Management System

Welcome to the Casino Management System project! This system is designed to help manage the financial operations of a casino, including expenses, machines, and readings.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [Contributing](#contributing)
- [License](#license)

## Overview

The Casino Management System is a Spring Boot application that allows for the management of casino-related operations. It provides functionalities to handle expenses, machines, and their respective readings. This system ensures efficient management and tracking of financial and operational aspects of a casino.

## Features

- **Manage Machines**: Add, update, view, and delete machine records.
- **Manage Expenses**: Track and manage various casino expenses.
- **Readings**: Record and retrieve readings associated with the machines.

## Technologies Used

- **Spring Boot**: Framework for building the application.
- **Spring Data JPA**: For data persistence.
- **Lombok**: To reduce boilerplate code.
- **Jakarta Validation**: For data validation.
- **Mysql**: database for development.
- **Maven**: For project management and dependency management.

## Getting Started

To get a local copy up and running, follow these steps.

### Prerequisites

- JDK 11 or later
- Maven

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/Wesleyweb30/casino.git
    ```
2. Navigate to the project directory:
    ```sh
    cd casino
    ```
3. Create database:
    ```sh
    casino
    ```

The application should now be running on `http://localhost:8080`.

## Endpoints

### Machine Endpoints

- **Create a new machine**: `POST /machines`
    - Request Body:
        ```json
        {
            "nome": "Slot Machine 1",
            "moeda": 1.0,
            "status": true
        }
        ```

- **Get all machines**: `GET /machines`

- **Get a machine by ID**: `GET /machines/{id}`

- **Update a machine**: `PUT /machines/{id}`
    - Request Body:
        ```json
        {
            "nome": "Updated Machine Name",
            "moeda": 2.0,
            "status": false
        }
        ```

- **Delete a machine**: `DELETE /machines/{id}`

### Expense Endpoints

- **Create a new expense**: `POST /expenses`
    - Request Body:
        ```json
        {
            "description": "Maintenance Cost",
            "amount": 100.0
        }
        ```

- **Get all expenses**: `GET /expenses`

- **Get an expense by ID**: `GET /expenses/{id}`

- **Update an expense**: `PUT /expenses/{id}`
    - Request Body:
        ```json
        {
            "description": "Updated Maintenance Cost",
            "amount": 120.0
        }
        ```

- **Delete an expense**: `DELETE /expenses/{id}`

### Reading Endpoints

- **Create a new reading**: `POST /readings`
    - Request Body:
        ```json
        {
            "machineId": 1,
            "initialEntry": 100.0,
            "finalEntry": 200.0,
            "initialExit": 50.0,
            "finalExit": 75.0,
            "result": 75.0
        }
        ```

- **Get all readings**: `GET /readings`

- **Get a reading by ID**: `GET /readings/{id}`

- **Update a reading**: `PUT /readings/{id}`
    - Request Body:
        ```json
        {
            "machineId": 1,
            "initialEntry": 150.0,
            "finalEntry": 250.0,
            "initialExit": 60.0,
            "finalExit": 80.0,
            "result": 110.0
        }
        ```

- **Delete a reading**: `DELETE /readings/{id}`


## License

Distributed under the MIT License. See `LICENSE` for more information.
