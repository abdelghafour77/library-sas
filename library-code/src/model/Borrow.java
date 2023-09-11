package model;

import java.time.LocalDate;

public class Borrow {
    int id;
    String email;
    String ISBN;
    String status;
    String description;
    LocalDate created_at;


    public Borrow(int id, String email, String ISBN, String status, String description, LocalDate created_at){
        this.id=id;
        this.email=email;
        this.ISBN=ISBN;
        this.status=status;
        this.description=description;
        this.created_at=created_at;

    }

    public Borrow(int id, String email, String ISBN, String status, String description) {
        this.id = id;
        this.email = email;
        this.ISBN = ISBN;
        this.status = status;
        this.description = description;
    }

    public int getId() {
        return id;
    }
    public String getEmail(){
        return this.email;
    }
    public String getISBN(){
        return this.ISBN;
    }
    public String getStatus(){
        return this.status;
    }
    public String getDescription(){
        return this.description;
    }
    public LocalDate getCreated_at(){
        return this.created_at;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setUser_id(String email){
        this.email=email;
    }
    public void setBook_id(String ISBN){
        this.ISBN=ISBN;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setCreated_at(LocalDate created_at){
        this.created_at=created_at;
    }


    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }


}
