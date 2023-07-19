import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements EmployeeDAO {
    private final String user = "postgres";
    private final String pass = "root";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public List<Employee> getAllEmployee () {
      List<Employee> employees = new ArrayList<>();

      try (final java.sql.Connection connection = DriverManager.getConnection(url, user, pass);
           PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee")) {
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
          int id = resultSet.getInt("id");
          String firstName = resultSet.getString("first_name");
          String lastName = resultSet.getString("last_name");
          String gender = resultSet.getString("gender");
          int age = resultSet.getInt("age");
          int cityId = resultSet.getInt("city_id");
          employees.add(new Employee(id, firstName, lastName, gender, age, cityId));
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return employees;
    }

    @Override
    public Employee getById ( int id){
      Employee employee = new Employee();
      try (final Connection connection = DriverManager.getConnection(url, user, pass);
           PreparedStatement statement = ((java.sql.Connection) connection).prepareStatement(
                   "SELECT * FROM employee WHERE id = (?)")) {

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
          employee.setId(resultSet.getInt(1));
          employee.setFirst_name(resultSet.getString("first_name"));
          employee.setLastName(resultSet.getString("last_name"));
          employee.setGender(resultSet.getString("gender"));
          employee.setAge(resultSet.getInt(5));
          employee.setCityId(resultSet.getInt("city_id"));

        }

      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
      return employee;
    }

    @Override
    public void createEmployee (Employee employee){
      try (final java.sql.Connection connection = DriverManager.getConnection(url, user, pass);
           PreparedStatement statement = connection.prepareStatement(
                   "INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES ( (?), (?), (?), (?), (?))")) {

        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getLastName());
        statement.setString(3, employee.getGender());
        statement.setInt(4, employee.getAge());
        statement.setInt(5, employee.getCityId());
        statement.executeUpdate();

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void updateEmployee ( int id, Employee employee){
      try (final java.sql.Connection connection = DriverManager.getConnection(url, user, pass);
           PreparedStatement statement = ((java.sql.Connection) connection).prepareStatement(
                   "UPDATE employee SET first_name= (?), last_name = (?), gender = (?), age = (?), city_id = (?) WHERE id = (?)")) {
//            statement.setInt(1, employee.getId());
        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getLastName());
        statement.setString(3, employee.getGender());
        statement.setInt(4, employee.getAge());
        statement.setInt(5, employee.getCityId());
        statement.setInt(6, id);
        statement.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }


    }

    @Override
    public void deleteEmployee ( int id){
      try (final java.sql.Connection connection = DriverManager.getConnection(url, user, pass);
           PreparedStatement statement = connection.prepareStatement(
                   "DELETE FROM employee WHERE id = (?)")) {
        statement.setInt(1, id);
        statement.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }


    }
  }