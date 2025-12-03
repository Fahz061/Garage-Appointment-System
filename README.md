# Auto Garage Appointment System

## Team Members
- Fahad Malik 
- Jacob Magera

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
- `database.sql` – Creates database schema and inserts sample services/customers/employees/appointments.
- `src/DatabaseConnection.java` – Handles the MySQL JDBC connection.
- `src/Customer.java` – Customer model.
- `src/Employee.java` – Employee model.
- `src/Appointment.java` – Appointment model.
- `src/CustomerDAO.java` – DAO interface.
- `src/CustomerDAOImpl.java` – DAO implementation for customers.
- `src/MainController.java` – Main logic controller.
- `src/MainView.java` – Basic Swing GUI.
- `src/Main.java` – Entry point of the program.

## Notes
- This is a starting point for the larger project.
- Only basic features are implemented for Deliverable 1.
