import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "root8351";
        final String url = "jdbc:postgresql://localhost:5432/skypro";


        City newCity = new City("Москва");

        Employee newEmployee = new Employee("Артем", "Матросов", "м", 37, newCity.getCity_id());


        newCity.setCity_name("Владимир");
    }
}
