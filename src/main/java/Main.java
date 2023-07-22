import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "0451";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password)) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
            CityDAO cityDAO = new CityDAOImpl(connection);

            City newCity = new City("Москва");
            cityDAO.insertCityIntoTable(newCity);

            Employee newEmployee = new Employee("Артем", "Матросов", "м", 37, newCity.getCity_id());
            employeeDAO.insertEmployeeIntoTable(newEmployee);
            employeeDAO.selectEmployeeById(4);
            employeeDAO.getAllEmployees();
            EmployeeDAO.updateEmployee(newEmployee);

            newCity.setCity_name("Владимир");
            cityDAO.updateCity(newCity);

            employeeDAO.dropEmployee(newEmployee);
            cityDAO.dropCity(newCity);
        }
    }
}
