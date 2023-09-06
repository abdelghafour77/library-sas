import database.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Date created_at;
    private Date updated_at;

    public User(int id, String name, String email, String password, String phone, Date created_at, Date updated_at){
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.phone=phone;
        this.created_at=created_at;
        this.updated_at=updated_at;
    }
    public User( String name, String email, String password, String phone, Date created_at){
        this.id= 0;
        this.name=name;
        this.email=email;
        this.password=password;
        this.phone=phone;
        this.created_at=created_at;
        this.updated_at=null;
    }

    public int getId() {
        return id;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public String getPhone(){
        return this.phone;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public String toString(){
        return "ID: "+this.id+"\n\t User: "+this.name+"\n\t Email: "+this.email+"\n\t Password: "+this.password+"\n\t Phone: "+this.phone+"\n\t Created at: "+this.created_at+"\n\t Updated at: "+this.updated_at;
    }
    public void insertIntoDatabase() {
        String insertSql = "INSERT INTO users (name, email, password, phone, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = Dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {

            preparedStatement.setString(1, this.name);
            preparedStatement.setString(2, this.email);
            preparedStatement.setString(3, this.password);
            preparedStatement.setString(4, this.phone);
            preparedStatement.setTimestamp(5, new java.sql.Timestamp(this.created_at.getTime()));
            preparedStatement.setTimestamp(6, new java.sql.Timestamp(this.updated_at.getTime()));


            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User inserted into the database.");
            } else {
                System.out.println("User insertion failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
