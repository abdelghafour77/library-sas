package repository;

import database.Dbconnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookRepository {
    private static Connection connection;
    private List<Book> books = new ArrayList<>();
    private int nextId = 1;
    private Date created_at = new Date();

    public BookRepository() {
        this.connection = Dbconnection.getConnection();
    }

    public void createBook(String title, int author_id, String isbn, int quantity) {


        books.add(new Book(nextId++,author_id, title,  isbn, quantity, quantity, created_at));
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