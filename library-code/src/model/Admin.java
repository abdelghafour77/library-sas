package model;

import java.util.Date;

public class Admin extends User {


    public Admin(int id,int is_admin, String name, String email, String password, String phone, Date created_at, Date updated_at) {
        super(id, is_admin, name, email, password, phone, created_at, updated_at);


    }

}
