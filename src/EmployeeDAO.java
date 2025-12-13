import java.util.List;


public interface EmployeeDAO {

 
    boolean addEmployee(Employee e);
    List<Employee> getAllEmployees();
    boolean updateEmployee(Employee e);
    boolean deleteEmployee(int employeeId);
}
