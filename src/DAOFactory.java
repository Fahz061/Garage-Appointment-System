public class DAOFactory {
    private DAOFactory () {

    }

    public static CustomerDAO getCustomerDAO() {
        return new CustomerDAOImpl();
        
    }
    public static  EmployeeDAO getEmployeeDAO() {
        return new EmployeeDAOImpl();
    }
    public static ServiceDAO getServiceDAO() {
        return new ServiceDAOImpl();
    }

    public static AppointmentDAO getAppointmentDAO() {
        return new AppointmentDAOImpl();
    }
}
