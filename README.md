# Hospital Report Management System

Hospital Report is a Spring Boot 3 application that demonstrates how to manage people and their medical reports using a Neo4j graph database. It exposes simple REST endpoints and HTML views for creating, updating and listing people with their associated reports.

## Features

- CRUD operations for persons and medical reports
- Neo4j integration via Spring Data Neo4j
- HTML templates rendered with Thymeleaf
- RESTful API design for programmatic access

## Project Structure

```
src/
 ├─ main/
 │  ├─ java/com/hm/HospitalReport/       # Java source code
 │  └─ resources/templates/               # Thymeleaf templates
 └─ test/java/com/hm/HospitalReport/      # Tests
```

Key classes:
- `HospitalReportApplication` – application entry point
- `Persons`, `Report`, `RelotionShip` – domain models
- `Controller`, `DBController` – web controllers
- `RepositoryPerson`, `ReportRepository` – Spring Data repositories

## Requirements

- Java 17 or higher
- Maven 3.8+
- A running Neo4j instance (default: `bolt://localhost:7687`)

## Setup

Clone the repository and build the project:

```bash
git clone <repo-url>
cd HospitalReport
mvn clean package
```

Configure Neo4j credentials in `src/main/resources/application.properties` or via environment variables:

```properties
spring.neo4j.uri=bolt://localhost:7687
spring.neo4j.authentication.username=neo4j
spring.neo4j.authentication.password=your_password
```

## Running the Application

Execute the application using Maven or the generated JAR file:

```bash
mvn spring-boot:run
# or
java -jar target/HospitalReport-0.0.1-SNAPSHOT.jar
```

Visit `http://localhost:8080/main` in your browser to access the web UI.

## API Endpoints (Examples)

- `GET /main` – list all persons
- `GET /report/view/{id}` – view a person's report
- `POST /report/createService` – create a person and report
- `POST /report/updateService` – update an existing person

## Testing

Run all tests with Maven:

```bash
mvn test
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project currently does not include an open-source license.
