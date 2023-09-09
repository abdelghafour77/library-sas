package model;

import database.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class User {
    private int id;
    private int is_admin;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Date created_at;
    private Date updated_at;

    public User(int id, int is_admin, String name, String email, String password, String phone, Date created_at, Date updated_at) {
        this.id = id;
        this.is_admin = is_admin;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public User(int id, int is_admin, String name, String email, String password, String phone, Date created_at) {
        this.id = id;
        this.is_admin = is_admin;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.created_at = created_at;
    }

    public User(String name, String email, String password, String phone, Date created_at) {
        this.id = 0;
        this.is_admin = 0;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.created_at = created_at;
        this.updated_at = null;
    }

    public int getId() {
        return id;
    }

    public String getIs_admin() {

        return this.is_admin == 1 ? "admin" : "client";
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPhone() {
        return this.phone;
    }

    public Date getCreated_at() {
        return this.created_at;
    }

    public Date getUpdated_at() {
        return this.updated_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIs_admin(int is_admin) {
        this.is_admin = is_admin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", type='" + getIs_admin() + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }


}
