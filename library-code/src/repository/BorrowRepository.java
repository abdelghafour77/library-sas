package repository;

import database.Dbconnection;
import model.Borrow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowRepository {

    private static Connection connection = Dbconnection.getConnection();

    private final List<Borrow> borrows = new ArrayList<>();

    public BorrowRepository() {
        connection = Dbconnection.getConnection();
    }

    public static List<Borrow> getAllBorrows() {
        List<Borrow> borrows = new ArrayList<>();

        try {
            String query = "SELECT * FROM borrows";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                int book_id = resultSet.getInt("book_id");
                String borrow_date = resultSet.getString("borrow_date");
                String return_date = resultSet.getString("return_date");
                String status = resultSet.getString("status");
                String description = resultSet.getString("description");

                borrows.add(new Borrow(id, user_id, book_id, borrow_date, return_date, status, description));
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
            String query = "INSERT INTO borrows (user_id, book_id, borrow_date, return_date, status, description) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, borrow.getUser_id());
            statement.setInt(2, borrow.getBook_id());
            statement.setString(3, borrow.getBorrow_date());
            statement.setString(4, borrow.getReturn_date());
            statement.setString(5, borrow.getStatus());
            statement.setString(6, borrow.getDescription());

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
                int user_id = resultSet.getInt("user_id");
                int book_id = resultSet.getInt("book_id");
                String borrow_date = resultSet.getString("borrow_date");
                String return_date = resultSet.getString("return_date");
                String status = resultSet.getString("status");
                String description = resultSet.getString("description");

                borrow = new Borrow(id, user_id, book_id, borrow_date, return_date, status, description);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrow;
    }

    public static List<Borrow> getBorrowByUserId(int user_id) {
        List<Borrow> borrows = new ArrayList<>();

        try {
            String query = "SELECT * FROM borrows WHERE user_id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, user_id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int book_id = resultSet.getInt("book_id");
                String borrow_date = resultSet.getString("borrow_date");
                String return_date = resultSet.getString("return_date");
                String status = resultSet.getString("status");
                String description = resultSet.getString("description");

                borrows.add(new Borrow(id, user_id, book_id, borrow_date, return_date, status, description));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrows;
    }

    public static List<Borrow> getBorrowByBookId(int book_id) {
        List<Borrow> borrows = new ArrayList<>();

        try {
            String query = "SELECT * FROM borrows WHERE book_id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, book_id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                String borrow_date = resultSet.getString("borrow_date");
                String return_date = resultSet.getString("return_date");
                String status = resultSet.getString("status");
                String description = resultSet.getString("description");

                borrows.add(new Borrow(id, user_id, book_id, borrow_date, return_date, status, description));
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
                int user_id = resultSet.getInt("user_id");
                int book_id = resultSet.getInt("book_id");
                String borrow_date = resultSet.getString("borrow_date");
                String return_date = resultSet.getString("return_date");
                String description = resultSet.getString("description");

                borrows.add(new Borrow(id, user_id, book_id, borrow_date, return_date, status, description));
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
            String query = "UPDATE borrows SET user_id=?, book_id=?, borrow_date=?, return_date=?, status=?, description=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, borrow.getUser_id());
            statement.setInt(2, borrow.getBook_id());
            statement.setString(3, borrow.getBorrow_date());
            statement.setString(4, borrow.getReturn_date());
            statement.setString(5, borrow.getStatus());
            statement.setString(6, borrow.getDescription());
            statement.setInt(7, borrow.getId());

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
