# Reppd

## Overview

Reppd is a full-stack application designed to help users track their
daily productivity tasks. Focused on fostering personal growth and skill
acquisition, Reppd allows users to track daily activities under
customizable competencies, such as language learning, coding, exercising,
and more. This repository covers the backend services,
which include robust APIs for tracking and querying daily tasks,
backed by a MySQL database and managed with Flyway for smooth database
migrations.

## Features

- **Competency Tracking:** Users can create and manage different competencies, such as foreign languages, coding skills, etc.
- **Activity Logging:** Daily activities related to each competency can be logged and tracked.
- **API Endpoints:** RESTful APIs for creating, updating, and retrieving user competencies and activities.
- **Secure and Scalable:** Built with Java and Spring Boot for robustness and scalability.
- **Database Management:** Integrated with MySQL and Flyway for efficient database handling.

## Getting Started

### Prerequisites

- Java 17
- Maven 3
- MySQL

### Installation

1. Clone the repository:

```shell
git clone https://github.com/jakegodsall/reppd-backend
```

2. Navigate to the project directory:

```shell
cd reppd-backend
```

3. Build the project using Maven:

```shell
mvn clean install
```

4. Configure your MySQL database settings in the `application.properties` file.

```properties
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/reppd_db
spring.datasource.username=<database_user>
spring.datasource.password=<database_password>
```

5. Run the application

```shell
java -jar target/reppd-0.0.1-SNAPSHOT.jar
```