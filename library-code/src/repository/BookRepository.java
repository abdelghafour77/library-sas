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
    private static Connection connection = Dbconnection.getConnection();

    public BookRepository() {
        connection = Dbconnection.getConnection();
    }

    public static boolean createBook(Book book) {
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
            return false;
        }
        return true;
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

                books.add(new Book(id, author_id, title, isbn, quantity, available_quantity, null, null));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return books;
    }

    public static Book getBookById(int id) {
        Book book = null;

        try {
            String query = "SELECT * FROM books WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int author_id = resultSet.getInt("author_id");
                String title = resultSet.getString("title");
                String isbn = resultSet.getString("isbn");
                int quantity = resultSet.getInt("quantity");
                int available_quantity = resultSet.getInt("available_quantity");

                book = new Book(id, author_id, title, isbn, quantity, available_quantity, null, null);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    public static Book getBookByIsbn(String isbn) {
        Book book = null;

        try {
            String query = "SELECT * FROM books WHERE isbn = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, isbn);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int author_id = resultSet.getInt("author_id");
                String title = resultSet.getString("title");
                int quantity = resultSet.getInt("quantity");
                int available_quantity = resultSet.getInt("available_quantity");

                book = new Book(id, author_id, title, isbn, quantity, available_quantity, null, null);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    public static List<Book> searchBook(String title) {
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

                books.add(new Book(id, author_id, title1, isbn, quantity, available_quantity, null, null));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public static boolean updateBook(Book book) {
        try {
            String query = "UPDATE books SET title = ?, author_id = ?, isbn = ?, quantity = ?, available_quantity = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getAuthor_id());
            statement.setString(3, book.getIsbn());
            statement.setInt(4, book.getQuantity());
            statement.setInt(5, book.getAvailable_quantity());
            statement.setInt(6, book.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean deleteBook(String ISBN) {
        try {
            String query = "DELETE FROM books WHERE isbn = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, ISBN);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
}