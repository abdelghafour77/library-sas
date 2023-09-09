package model;

import java.util.Date;

public class Client extends User {

    private String address;

    public Client(int id, int is_admin, String name, String email, String password, String phone, String address, Date created_at, Date updated_at) {
        super(id, is_admin, name, email, password, phone, created_at, updated_at);
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + getId() +
                ", type='" + getIs_admin() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", address='" + address + '\'' +
                ", created_at=" + getCreated_at() +
                ", updated_at=" + getUpdated_at() +
                '}';
    }
}
