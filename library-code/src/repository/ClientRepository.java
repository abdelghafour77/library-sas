package repository;

import database.Dbconnection;
import model.Admin;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientRepository {

    private static Connection connection = Dbconnection.getConnection();

    public static void createClient(Client client) {
        try {
            String query = "INSERT INTO users (is_admin, name, email, password, phone, address) VALUES (0, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, client.getName());
            statement.setString(2, client.getEmail());
            statement.setString(3, client.getPassword());
            statement.setString(4, client.getPhone());
            statement.setString(5, client.getAddress());

            statement.executeUpdate();

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateClient(Client client) {
        try {
            String query = "UPDATE users SET name = ?, email = ?, password = ?, phone = ?, address = ? WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, client.getName());
            statement.setString(2, client.getEmail());
            statement.setString(3, client.getPassword());
            statement.setString(4, client.getPhone());
            statement.setString(5, client.getAddress());
            statement.setInt(6, client.getId());

            statement.executeUpdate();

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteClient(int id) {
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

    public static Client getUserById(int id) {
        Client user = null;
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

                user = new Client(id, is_admin, name, email, null, phone, address, null, null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


}
