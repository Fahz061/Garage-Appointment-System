import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static Connection conn;

    private DatabaseConnection() {}

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/appointment_system",
                        "root",
                        "pass1234"
                );

                System.out.println("Connection successful!!!!!!!");
            }
        } catch (Exception e) {
            System.out.println("Error connecting to DB: " + e.getMessage());
        }
        return conn;
    }
}
