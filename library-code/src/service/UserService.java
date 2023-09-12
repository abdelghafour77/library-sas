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

    public static Client getUserByEmail(String email) {
        return ClientRepository.getUserByEmail(email);
    }

    public static void createClient(Client client) {
        ClientRepository.createClient(client);
    }

    public static void deleteClient(String email) {

        // find the client by email
        Client existingClient = ClientRepository.getUserByEmail(email);
        if (existingClient != null) {
            ClientRepository.deleteClient(email);
        } else {
            throw new IllegalArgumentException("Client with email " + email + " not found.");
        }


    }
}
