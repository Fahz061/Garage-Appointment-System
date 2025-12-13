import java.util.List;

public interface AppointmentDAO {

    //CREATE
    void addAppointment(Appointment appointment);

    //READ
    Appointment getAppointmentById(int id);
    List<Appointment> getAllAppointments();

    //UPDATE
    void updateAppointment(Appointment appointment);

    //DELETE
    void deleteAppointment(int id);
}

