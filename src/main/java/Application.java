import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void main(String[] args, Employee newEmployee) throws SQLException {

        final String user = "postgres";
        final String password = "root8351";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            CityDAO cityDAO = new CityDAOImpl(connection);
            City newCity = new City("Саратов");
            employeeList.add(new Employee("Артем", "Матросов", "м", 42, 23));
            employeeList.add(new Employee("Marina", "Федоровна", "ж", 47, 43));
            employeeList.add(new Employee("Марина", "Губкина", "ж", 23, 23));
            employeeList.add(new Employee("Сергей", "Давыдов", "м", 35, 47));
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
            for (Employee e : employeeList)
                employeeDAO.insertEmployeeIntoTable(e);
            employeeDAO.selectEmployeeById(4);
            employeeDAO.getAllEmployees();
            employeeDAO.updateEmployee(new Employee("Артем", "Матросов", "м", 27, 23));
            employeeDAO.dropEmployee(employeeList.get(2));
            cityDAO.dropCity(newCity);
        }
    }
}
