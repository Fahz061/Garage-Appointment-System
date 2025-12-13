import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOImpl implements ServiceDAO {

    @Override
    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();
        String sql = "SELECT * FROM services";

        try (Connection conn = DatabaseConnection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Service service = new Service(
          rs.getInt("service_id"),
         rs.getString("name")
                );
                services.add(service);
            }

        } catch (Exception e) {
          e.printStackTrace();
        }

        return services;
    }
}
