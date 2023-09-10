package repository;

import database.Dbconnection;
import model.Admin;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository {

    private static Connection connection = Dbconnection.getConnection();

    public static void createAdmin(Admin admin) {
        try {
            String query = "INSERT INTO users (is_admin, name, email, password, phone) VALUES (1, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, admin.getName());
            statement.setString(2, admin.getEmail());
            statement.setString(3, admin.getPassword());
            statement.setString(4, admin.getPhone());

            statement.executeUpdate();

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateAdmin(Admin admin) {
        try {
            String query = "UPDATE users SET name = ?, email = ?, password = ?, phone = ?, address = ? WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, admin.getName());
            statement.setString(2, admin.getEmail());
            statement.setString(3, admin.getPassword());
            statement.setString(3, admin.getPhone());
            statement.setInt(4, admin.getId());

            statement.executeUpdate();

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteAdmin(int id) {
        try {
            String query = "DELETE FROM users WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            statement.executeUpdate();

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Admin> getAllAdmins() {

        List<Admin> admins = new ArrayList<>();

        try {
            String query = "SELECT * FROM users WHERE is_admin = 1";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int is_admin = resultSet.getInt("is_admin");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");

                admins.add(new Admin(id, is_admin, name, email, password, phone, null, null));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return admins;
    }

    public static List<Admin> getAllUsers() {
        List<Admin> admins = new ArrayList<>();
        try {
            String query = "SELECT * FROM users ";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int is_admin = resultSet.getInt("is_admin");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");

                admins.add(new Admin(id, is_admin, name, email, password, phone, null, null));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return admins;
    }

    public static Admin getUserById(int id) {
        Admin admin = null;
        try {
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int is_admin = resultSet.getInt("is_admin");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");

                admin = new Admin(id, is_admin, name, email, phone, address, null, null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

    public static Admin getUserByEmail(String email){
        Admin admin=null;
        try {
            String query = "SELECT * FROM users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int is_admin = resultSet.getInt("is_admin");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");

                admin = new Admin(id, is_admin, name, email,password, phone, null, null);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return admin;
    }

}
