import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {

    // CREATE
    @Override
    public void addAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointments " +
                     "(customer_id, employee_id, service_id, date, time, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, appointment.getCustomerId());
            stmt.setInt(2, appointment.getEmployeeId());
            stmt.setInt(3, appointment.getServiceId());
            stmt.setString(4, appointment.getDate());
            stmt.setString(5, appointment.getTime());
            stmt.setString(6, appointment.getStatus());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ (by ID)
    @Override
    public Appointment getAppointmentById(int id) {
        String sql = "SELECT * FROM appointments WHERE appointment_id = ?";
        Appointment appointment = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                appointment = new Appointment(
                        rs.getInt("appointment_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("employee_id"),
                        rs.getInt("service_id"),
                        rs.getString("date"),
                        rs.getString("time"),
                        rs.getString("status")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return appointment;
    }

    // READ (all)
    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Appointment appointment = new Appointment(
                        rs.getInt("appointment_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("employee_id"),
                        rs.getInt("service_id"),
                        rs.getString("date"),
                        rs.getString("time"),
                        rs.getString("status")
                );
                appointments.add(appointment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return appointments;
    }

    // UPDATE
    @Override
    public void updateAppointment(Appointment appointment) {
        String sql = "UPDATE appointments SET " +
                     "customer_id = ?, employee_id = ?, service_id = ?, " +
                     "date = ?, time = ?, status = ? " +
                     "WHERE appointment_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, appointment.getCustomerId());
            stmt.setInt(2, appointment.getEmployeeId());
            stmt.setInt(3, appointment.getServiceId());
            stmt.setString(4, appointment.getDate());
            stmt.setString(5, appointment.getTime());
            stmt.setString(6, appointment.getStatus());
            stmt.setInt(7, appointment.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    @Override
    public void deleteAppointment(int id) {
        String sql = "DELETE FROM appointments WHERE appointment_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
