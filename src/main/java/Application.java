import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        final String user = "postgres";
        final String password = "4658686ghcj4745";
        final String url = "jdbc:postgresql://localhost:5432/skypro";


        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM books")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idOfBook = resultSet.getInt("book_id");
                System.out.println("ID книги: " + idOfBook);

                String titleOfBook = resultSet.getString("title");
                int authorOfBook = resultSet.getInt("author_id");
                int amountOfBook = resultSet.getInt("amount");

                System.out.println("Название: " + titleOfBook);
                System.out.println("ID автора: " + authorOfBook);
                System.out.println("Количество: " + amountOfBook);
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        public class Application2 {

            public static void main(String[] args) {
                BookDAO bookDAO = new BookDAOImpl();
                List<Book> books = bookDAO.getAllBooks();

                for (Book book : books) {
                    System.out.println("Book ID: " + book.getId());
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("Author_id: " + book.getAuthorId());
                    System.out.println("Amount: " + book.getAmount());
                }
            }
        }
    }
}