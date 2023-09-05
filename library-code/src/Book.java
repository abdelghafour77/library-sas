import database.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Book {
    private int id;
    private String title;
    private String isbn;
    private int quantity;
    private int quantity_intial;

    private Date created_at;
    private Date updated_at;

    public Book(int id, String title, String isbn, int quantity, int quantity_intial, Date created_at, Date updated_at){
        this.id=id;
        this.title=title;
        this.isbn=isbn;
        this.quantity=quantity;
        this.quantity_intial=quantity_intial;
        this.created_at=created_at;
        this.updated_at=updated_at;
    }

    public int getId() {
        return id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getIsbn(){
        return this.isbn;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public int getQuantity_intial(){
        return this.quantity_intial;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setIsbn(String isbn){
        this.isbn=isbn;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public void setQuantity_intial(int quantity_intial){
        this.quantity_intial=quantity_intial;
    }


    public void insertIntoDatabase() {
        String insertSql = "INSERT INTO books (title, isbn, quantity, quantity_intial, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            pstmt.setString(1, this.title);
            pstmt.setString(2, this.isbn);
            pstmt.setInt(3, this.quantity);
            pstmt.setInt(4, this.quantity_intial);
            pstmt.setDate(5, new java.sql.Date(this.created_at.getTime()));
            pstmt.setDate(6, new java.sql.Date(this.updated_at.getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
