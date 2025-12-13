import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public boolean addEmployee(Employee e) {
        String sql = "INSERT INTO employees (name, specialty) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setString(2, e.getSpecialty());
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("addEmployee error: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT employee_id, name, specialty FROM employees";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("name"),
                        rs.getString("specialty")
                );
                list.add(e);
            }

        } catch (Exception ex) {
            System.out.println("getAllEmployees error: " + ex.getMessage());
        }

        return list;
    }

    @Override
    public boolean updateEmployee(Employee e) {
        String sql = "UPDATE employees SET name=?, specialty=? WHERE employee_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setString(2, e.getSpecialty());
            ps.setInt(3, e.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("updateEmployee error: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employees WHERE employee_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, employeeId);
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("deleteEmployee error: " + ex.getMessage());
            return false;
        }
    }
}
