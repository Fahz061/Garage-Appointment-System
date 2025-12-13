import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainController {

    private final CustomerDAO customerDAO;
    private final EmployeeDAO employeeDAO;
    private final ServiceDAO serviceDAO;
    private final AppointmentDAO appointmentDAO;

    // cache serviceId to serviceName (Collection #2: HashMap)
    private final Map<Integer, String> serviceNameMap = new HashMap<>();

    public MainController() {
        // Factory pattern used here
        this.customerDAO = DAOFactory.getCustomerDAO();
        this.employeeDAO = DAOFactory.getEmployeeDAO();
        this.serviceDAO = DAOFactory.getServiceDAO();
        this.appointmentDAO = DAOFactory.getAppointmentDAO();

        loadServiceCache();
    }

    //SERVICES 
    private void loadServiceCache() {
        serviceNameMap.clear();
        List<Service> services = serviceDAO.getAllServices();
        for (Service s : services) {
            serviceNameMap.put(s.getId(), s.getName());
        }
    }

    public String getServiceName(int serviceId) {
        return serviceNameMap.getOrDefault(serviceId, "Unknown");
    }

    //CUSTOMERS 
    public boolean addCustomer(String name, String phone) {
        if (name == null || name.isBlank() || phone == null || phone.isBlank()) {
            return false;
        }
        return customerDAO.addCustomer(new Customer(name.trim(), phone.trim()));
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public boolean deleteCustomer(int customerId) {
        return customerDAO.deleteCustomer(customerId);
    }

    //EMPLOYEES 
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    //APPOINTMENTS
    public void addAppointment(int customerId, int employeeId, int serviceId,
           String date, String time, String status) {

        //basic validation
        if (date == null || date.isBlank() || time == null || time.isBlank()) {
            System.out.println("Invalid date/time.");
            return;
        }
        if (status == null || status.isBlank()) {
            status = "Pending";
        }

        Appointment a = new Appointment(customerId, employeeId, serviceId,
                date.trim(), time.trim(), status.trim());

        appointmentDAO.addAppointment(a);
    }
    

    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }

    public void deleteAppointment(int appointmentId) {
        appointmentDAO.deleteAppointment(appointmentId);
    }

    public void updateAppointmentStatus(int appointmentId, String newStatus) {
        Appointment a = appointmentDAO.getAppointmentById(appointmentId);
        if (a == null) {
            System.out.println("Appointment not found.");
            return;
        }
        a.setStatus(newStatus);
        appointmentDAO.updateAppointment(a);
    }
    //Lambda + streams
    public List<Appointment> getAppointmentsByStatus(String status) {
        return appointmentDAO.getAllAppointments()
                .stream()
                .filter(a -> a.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }
}
