import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();
    Employee getById(int id);
    void createEmployee(Employee employee);

    entityManager.merge(updatedEmployee);

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
    entityManager.remove(Employee);
}
