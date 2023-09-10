package service;

import model.Admin;
import model.Client;
import repository.AdminRepository;
import repository.ClientRepository;

import java.util.List;

public class UserService {


    public static List<Admin> getAllAdmins() {
        return AdminRepository.getAllAdmins();
    }

    public static List<Admin> getAllUsers() {
        return AdminRepository.getAllUsers();
    }

    public static Admin getUserByEmail(String email) {
        return AdminRepository.getUserByEmail(email);
    }

    public static void createClient(Client client) {
        ClientRepository.createClient(client);
    }
}
