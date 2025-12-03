import java.util.List;

public class MainController {

    private CustomerDAO customerDAO = new CustomerDAOImpl();

    public boolean addCustomer(String name, String phone) {
        Customer c = new Customer(name, phone);
        return customerDAO.addCustomer(c);
    }

    public List<Customer> loadCustomers() {
        return customerDAO.getAllCustomers();
    }
}
