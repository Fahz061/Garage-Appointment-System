public class Appointment {
    private int id;
    private int customerId;
    private int employeeId;
    private int serviceId;
    private String date;
    private String time;

    public Appointment() {}

    public Appointment(int id, int customerId, int employeeId, int serviceId, String date, String time) {
        this.id = id;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.serviceId = serviceId;
        this.date = date;
        this.time = time;
    }

    public Appointment(int customerId, int employeeId, int serviceId, String date, String time) {
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.serviceId = serviceId;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getServiceId()
    {
        return serviceId; }
    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getDate() { return date; }
    public void setDate(String date)
    { this.date = date;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
