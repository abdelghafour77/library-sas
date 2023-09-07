package repository;

import database.Dbconnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static Connection connection;
    private final List<Book> books = new ArrayList<>();


    public BookRepository() {
        connection = Dbconnection.getConnection();
    }

    public static void createBook(Book book) {
        try {
            String query = "INSERT INTO books (title, author_id, isbn, quantity, available_quantity) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getAuthor_id());
            statement.setString(3, book.getIsbn());
            statement.setInt(4, book.getQuantity());
            statement.setInt(5, book.getQuantity());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        try {
            String query = "SELECT * FROM books";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int author_id = resultSet.getInt("author_id");
                String title = resultSet.getString("title");
                String isbn = resultSet.getString("isbn");
                int quantity = resultSet.getInt("quantity");
                int available_quantity = resultSet.getInt("available_quantity");

                books.add(new Book(id, author_id, title, isbn, quantity, available_quantity,null,null));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return books;
    }

    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> searchBook(String title) {
        List<Book> books = new ArrayList<>();

        try {
            String query = "SELECT * FROM books WHERE title LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + title + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int author_id = resultSet.getInt("author_id");
                String title1 = resultSet.getString("title");
                String isbn = resultSet.getString("isbn");
                int quantity = resultSet.getInt("quantity");
                int available_quantity = resultSet.getInt("available_quantity");

                books.add(new Book(id, author_id, title1, isbn, quantity, available_quantity,null,null));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public void updateBook(int id, String title, String author) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(title);
               // book.setAuthor(author);
            }
        }
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}