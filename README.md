# Auto Garage Appointment System

## Team Members
- Fahad Malik (2056634)
- Jacob Magera (Student ID)

## Project Description
This project is a simple appointment management system for a local auto garage.  
It allows basic CRUD operations on customers and appointments.  
The application connects to a MySQL database using JDBC and uses the DAO pattern for data access.

Deliverable 1 includes:
- Database schema (tables and sample data)
- JDBC connection class
- Model classes (Customer, Employee, Appointment)
- DAO interfaces and implementations
- A basic Swing GUI with buttons to test database operations

## How to Run the SQL Script
1. Open MySQL Workbench.
2. Connect to your local MySQL server.
3. Open a new SQL tab.
4. Copy and paste the contents of `database.sql`.
5. Click the "Execute" (lightning bolt) button.
6. Refresh the schema list to see the new tables and sample data.

## Database Server Used
- **MySQL Community Server**  
  Version: 8.x (local installation on macOS)

## How to Run the Java Application
1. Open the project in IntelliJ.
2. Make sure the MySQL Connector/J library is added under  
   `File > Project Structure > Libraries`.
3. Open the `Main.java` file.
4. Run the program from IntelliJ using the green Run button.
5. Use the GUI window to test adding and viewing customers.

## File Contents
-database.sql – Creates database schema and inserts sample data

-DatabaseConnection.java – Handles MySQL JDBC connection

-Customer.java – Customer model

-Employee.java – Employee model

-Service.java – Service model

-Appointment.java – Appointment model

-DAO interfaces and implementations – Handle CRUD operations

-MainController.java – Business logic and validation

-MainView.java – Swing GUI

-Main.java – Application entry point

## Software Design Patterns Used 
- MVC (Model-View-Controller)
Separates the application into models, controller logic, and user interface

-DAO (Data Access Object)
Abstracts database access and keeps SQL logic separate from application logic

-Factory Pattern
DAOFactory centralizes the creation of DAO objects

-Singleton Pattern
DatabaseConnection ensures a single database connection instance

## Error Handling & Validation 
-Input validation is performed before database operations

-Invalid or missing data is handled safely

-Database errors are handled using try-catch blocks


## Java Collections & Streams 
-ArrayList is used to store collections of data retrieved from the database

-HashMap is used to cache service IDs and service names for fast lookup

-Java Stream API is used to filter appointments by status using lambda expressions

## Contribution Statement 


## Fahad Malik:

-Designed and implemented the database schema

-Implemented JDBC connection logic

-Created model classes

-Implemented DAO interfaces and implementations

-Implemented Factory and Singleton patterns

-Built controller logic and validation

-Used Java Collections and Stream API

## Jacob Magera:

-User interface improvements (Swing)

-Internationalization support (English/French)

-Presentation and video demonstration support


## Notes
- This project can be upgraded further with additional features being added to it to improve the usability of it.

- This project is very useful in real-world businesses involving an appointment system.
