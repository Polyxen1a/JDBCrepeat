import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "root8351";
        final String url = "jdbc:postgresql://localhost:5432/skypro";


        City newCity = new City("Москва");

        Employee newEmployee1 = new Employee("Артем", "Матросов", "м", 37, newCity.getCity_id());
        Employee newEmployee2 = new Employee("Марина", "Федоровна", "ж", 47, 43);
        Employee newEmployee3 = new Employee("Марина", "Губкина", "ж", 23, 23);
        Employee newEmployee4 = new Employee("Сергей", "Давыдов", "м", 35, 47);

        newCity.setCity_name("Владимир");
    }
}
