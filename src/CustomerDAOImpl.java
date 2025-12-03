import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean addCustomer(Customer c) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO customers (name, phone) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getPhone());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Add error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM customers";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("phone")
                ));
            }
        } catch (Exception e) {
            System.out.println("Fetch error: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean updateCustomer(Customer c) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE customers SET name=?, phone=? WHERE customer_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getPhone());
            ps.setInt(3, c.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Update error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(int id) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "DELETE FROM customers WHERE customer_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Delete error: " + e.getMessage());
            return false;
        }
    }
}

