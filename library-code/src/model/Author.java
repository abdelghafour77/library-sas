package model;

import database.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Author {
    private int id;
    private String name;
    private String biography;
    private Date created_at;
    private Date updated_at;

    public Author(int id, String name, String biography, Date created_at, Date updated_at){
        this.id=id;
        this.name=name;
        this.biography=biography;
        this.created_at=created_at;
        this.updated_at=updated_at;
    }

    public int getId() {
        return id;
    }
    public String getName(){
        return this.name;
    }
    public String getBiography(){
        return this.biography;
    }
   

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setBiography(String biography){
        this.biography=biography;
    }

    public void insertIntoDatabase() {
        String insertSql = "INSERT INTO authors (name, biography, created_at, updated_at) VALUES (?, ?, ?, ?)";
        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(insertSql)) {
            preparedStatement.setString(1, this.name);
            preparedStatement.setString(2, this.biography);
            preparedStatement.setDate(3, new java.sql.Date(this.created_at.getTime()));
            preparedStatement.setDate(4, new java.sql.Date(this.updated_at.getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   

}
