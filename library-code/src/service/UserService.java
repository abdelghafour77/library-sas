package service;

import model.Admin;
import repository.AdminRepository;

import java.util.List;

public class UserService {


    public static List<Admin> getAllAdmins() {
        return AdminRepository.getAllAdmins();
    }

    public static List<Admin> getAllUsers() {
        return AdminRepository.getAllUsers();
    }
}
