package repository;

import database.Dbconnection;
import model.Author;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    private static Connection connection = Dbconnection.getConnection();

    public AuthorRepository() {
        connection = Dbconnection.getConnection();
    }

    public static void createAuthor(Author author) {
        try {
            String query = "INSERT INTO authors (name, biography) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, author.getName());
            statement.setString(2, author.getBiography());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();

        try {
            String query = "SELECT * FROM authors";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String biography = resultSet.getString("biography");

                authors.add(new Author(id, name, biography, null, null));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authors;
    }

    public static Author getAuthorById(int id) {
        Author author = null;

        try {
            String query = "SELECT * FROM authors WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String biography = resultSet.getString("biography");

                author = new Author(id, name, biography, null, null);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return author;
    }

    public static Author getAuthorByName(String name) {
        Author author = null;

        try {
            String query = "SELECT * FROM authors WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String biography = resultSet.getString("biography");

                author = new Author(id, name, biography, null, null);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return author;
    }

    public static Author updateAuthor(Author author) {
        try {
            String query = "UPDATE authors SET name = ?, biography = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, author.getName());
            statement.setString(2, author.getBiography());
            statement.setInt(3, author.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return author;
    }

    public static void deleteAuthor(int id) {
        try {
            String query = "DELETE FROM authors WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
