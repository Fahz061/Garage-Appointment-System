import java.util.List;

public interface CustomerDAO {
    boolean addCustomer(Customer c);
    List<Customer> getAllCustomers();
    boolean updateCustomer(Customer c);
    boolean deleteCustomer(int id);
}

