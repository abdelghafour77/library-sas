package controller;

import model.Admin;
import model.Client;
import repository.AdminRepository;
import repository.ClientRepository;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserController {
    private static final Scanner scanner = new Scanner(System.in);
    //create method to add user

    public static Client login() {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        Client user = UserService.getUserByEmail(email);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                System.out.println("Login successful.");
                return user;

            } else {
                System.out.println("Invalid password.");
            }
        } else {
            System.out.println("No user found with email \"" + email + "\".");
        }
        return null;
    }

    public static boolean isUserAdmin(Admin user) {
        return user.getIs_admin().equals("admin");
    }

    public static void listAllAdmins() {
        System.out.println("\nList All Admins :");

        List<Admin> admins;
        admins = AdminRepository.getAllAdmins();

        for (Admin admin : admins) {
            System.out.println(admin.toString() + "\n");
        }
    }

    public static void listAllUsers() {
        System.out.println("\nList All Users :");

        List<Admin> users;
        users = AdminRepository.getAllUsers();

        for (Admin user : users) {
            System.out.println(user.toString() + "\n");
        }
    }

    public static void addAdmin() {
        System.out.print("Enter the name of the admin: ");
        String name = scanner.nextLine();
        System.out.print("Enter the email of the admin: ");
        String email = scanner.nextLine();
        System.out.print("Enter the password of the admin: ");
        String password = scanner.nextLine();
        System.out.print("Enter the phone of the admin: ");
        String phone = scanner.nextLine();

        AdminRepository.createAdmin(new Admin(1, 1, name, email, password, phone, null, null));
        System.out.println("Admin added successfully.");
    }

    public static Client addClient() {
        Client user = null;
        System.out.print("Enter the name of the user: ");
        String name = scanner.nextLine();
        System.out.print("Enter the email of the user: ");
        String email = scanner.nextLine();
        System.out.print("Enter the password of the user: ");
        String password = scanner.nextLine();
        System.out.print("Enter the phone of the user: ");
        String phone = scanner.nextLine();
        System.out.println("Enter the address of the user: ");
        String address = scanner.nextLine();
        user = new Client(1, 0, name, email, password, phone, address, null, null);
        UserService.createClient(user);

        System.out.println("User added successfully.");
        return user;
    }

    public static void viewUserDetails() {
        System.out.print("Enter the id of the user: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Client user = ClientRepository.getUserById(id);

        if (user != null) {
            System.out.println(user.toString());
        } else {
            System.out.println("No user found with id " + id);
        }
    }

    public static void updateUserDetails() {
        System.out.print("Enter the id of the user: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Client user = ClientRepository.getUserById(id);

        if (user != null) {
            System.out.println(user.toString());
            System.out.println("Enter the name of the user: ");
            String name = scanner.nextLine();
            System.out.println("Enter the email of the user: ");
            String email = scanner.nextLine();
            System.out.println("Enter the password of the user: ");
            String password = scanner.nextLine();
            System.out.println("Enter the phone of the user: ");
            String phone = scanner.nextLine();
            System.out.println("Enter the address of the user: ");
            String address = scanner.nextLine();
            ClientRepository.updateClient(new Client(id, 0, name, email, password, phone, address, null, null));
            System.out.println("User updated successfully.");
        } else {
            System.out.println("No user found with id " + id);
        }
    }

    public static void deleteUser() {
        System.out.print("Enter the Email of the user: ");
        String email = scanner.nextLine();

        Client user = ClientRepository.getUserByEmail(email);

        if (user != null) {
            ClientRepository.deleteClient(email);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("No user found with email " + email);
        }
    }

}
