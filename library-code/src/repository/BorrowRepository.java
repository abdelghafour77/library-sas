package repository;

import database.Dbconnection;
import model.Borrow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowRepository {

    private static Connection connection = Dbconnection.getConnection();

    public static List<Borrow> getAllBorrows() {

        List<Borrow> borrows = new ArrayList<>();

        try {
            String query = "SELECT * FROM borrows";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String ISBN = resultSet.getString("ISBN");
                String status = resultSet.getString("status");
                String description = resultSet.getString("description");

                borrows.add(new Borrow(id, email, ISBN, status, description));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrows;
    }

    public static void createBorrow(Borrow borrow) {
        try {
            String query = "INSERT INTO borrows (email, ISBN, status, description) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, borrow.getEmail());
            statement.setString(2, borrow.getISBN());
            statement.setString(3, borrow.getStatus());
            statement.setString(4, borrow.getDescription());

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Borrow getBorrowById(int id) {

        Borrow borrow = null;

        try {
            String query = "SELECT * FROM borrows WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String ISBN = resultSet.getString("ISBN");
                String status = resultSet.getString("status");
                String description = resultSet.getString("description");

                borrow = new Borrow(id, email, ISBN, status, description);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrow;
    }

    public static List<Borrow> getBorrowByEmail(String email) {
        List<Borrow> borrows = new ArrayList<>();

        try {
            String query = "SELECT * FROM borrows WHERE email=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ISBN = resultSet.getString("ISBN");
                String status = resultSet.getString("status");
                String description = resultSet.getString("description");

                borrows.add(new Borrow(id, email, ISBN, status, description));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrows;
    }

    public static List<Borrow> getBorrowByISBN(String ISBN) {
        List<Borrow> borrows = new ArrayList<>();

        try {
            String query = "SELECT * FROM borrows WHERE ISBN=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, ISBN);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String status = resultSet.getString("status");
                String description = resultSet.getString("description");


                borrows.add(new Borrow(id, email, ISBN, status, description));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrows;
    }

    public static List<Borrow> getBorrowByStatus(String status) {
        List<Borrow> borrows = new ArrayList<>();

        try {
            String query = "SELECT * FROM borrows WHERE status=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, status);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String ISBN = resultSet.getString("ISBN");
                String description = resultSet.getString("description");

                borrows.add(new Borrow(id, email, ISBN, status, description));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrows;
    }

    public static Borrow updateBorrow(Borrow borrow) {
        try {
            String query = "UPDATE borrows SET email=?, ISBN=?, status=?, description=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, borrow.getEmail());
            statement.setString(2, borrow.getISBN());
            statement.setString(3, borrow.getStatus());
            statement.setString(4, borrow.getDescription());
            statement.setInt(5, borrow.getId());

            statement.executeUpdate();

            statement.close();
            return borrow;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteBorrow(int id) {
        try {
            String query = "DELETE FROM borrows WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
