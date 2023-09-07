package model;

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
    private int available_quantity;
    private int author_id;
    private Date created_at;
    private Date updated_at;

    public Book() {
    }

    public Book(int id, int author_id, String title, String isbn, int quantity, int available_quantity, Date created_at, Date updated_at){
        this.id=id;
        this.title=title;
        this.isbn=isbn;
        this.quantity=quantity;
        this.available_quantity=available_quantity;
        this.author_id=author_id;
        this.created_at=created_at;
        this.updated_at=updated_at;
    }

    public Book(int id, int author_id, String title, String isbn, int quantity, int available_quantity, Date created_at) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.quantity = quantity;
        this.available_quantity = available_quantity;
        this.author_id = author_id;
        this.created_at = created_at;
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
    public int getAvailable_quantity(){
        return this.available_quantity;
    }
    public int getAuthor_id(){
        return this.author_id;
    }
    public Date getCreated_at(){
        return this.created_at;
    }
    public Date getUpdated_at(){
        return this.updated_at;
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
    public void setAvailable_quantity(int available_quantity){
        this.available_quantity=available_quantity;
    }
    public void setAuthor_id(int author_id){
        this.author_id=author_id;
    }


}
