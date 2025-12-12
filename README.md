Theme Park - README

The Theme Park project is structured using a modular layered architecture, clearly separating responsibilities and ensuring maintainability, isolated testing, and future scalability. The system architecture is reflected directly in the implemented code and includes three main layers:

Domain Layer – represented by the User, Ride, and Ticket classes, which store the core data and methods of the entities. This layer ensures encapsulation and a clear data model for users, rides, and tickets, protecting the integrity of the information.

Service Layer – includes AuthService and ParkService. AuthService manages user registration and authentication, while ParkService handles operations on rides and tickets, including ticket purchasing, capacity checks, and role verification (GUEST, ADMIN). This layer centralizes critical business logic and protects the domain layer from direct manipulation.

Data Access Layer – implemented by the Repository interface and InMemoryRepository class. This layer provides in-memory CRUD operations for entities, isolating data storage from business logic and allowing easy replacement with a real database if needed.

The modular design and clear separation of responsibilities allow for independent unit testing. Unit tests are implemented in AuthServiceTest and ParkServiceTest using JUnit 5, covering critical functionalities such as user registration, login, ticket purchasing, ride management, and role-based access control.

Code Coverage

The project uses the Jacoco plugin to measure code coverage of the unit tests. To generate a code coverage report, first run all tests with:

mvn test


Then generate the coverage report with:

mvn jacoco:report


The report is produced in the target/site/jacoco/ directory and provides detailed information about which parts of the code are covered by tests. If this directory or report does not exist, it means that either no tests have been executed or the Jacoco report goal has not run.

How to Use the Project
1. Clone the Project
git clone https://github.com/<username>/themepark.git
cd themepark

2. Build and Compile
mvn clean compile

3. Run the Application

The console application can be run directly with Maven:

mvn exec:java -Dexec.mainClass="themepark.Main"


Or by packaging into a .jar and running:

mvn package
java -jar target/themepark-1.0-SNAPSHOT.jar

4. Console Commands

login <email> <password> – log in as an existing user.

buy <userId> <rideId> – purchase a ticket for a specific ride.

exit – exit the application.

5. Run Unit Testing
mvn test


This command executes all unit tests and displays the results in the console.

6. Versioning and Collaboration

Invite collaborators with Write access to the repository.

Collaborators clone, make changes, commit, and push using their credentials or personal token.

All changes are tracked in the repository, ensuring consistency and traceability.

This README provides a complete overview of the project architecture, modular layers, unit testing, code coverage, and practical usage instructions—all in one formal and ready-to-use document.\
