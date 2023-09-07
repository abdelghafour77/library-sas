import controller.BookController;
import controller.UserController;

import repository.BookRepository;
import service.BookService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);
        UserController userController = new UserController();


        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Books");
            System.out.println("2. Users");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    bookMenu( scanner);
                    break;
                case 2:
                    userMenu(userController, scanner); // You should create a userMenu method similarly
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void bookMenu( Scanner scanner) {
        while (true) {
            System.out.println("\nBooks Menu");
            System.out.println("1. List All Books");
            System.out.println("2. Add a Book");
            System.out.println("3. View Book Details");
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete a Book");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    BookController bookController = new BookController();
                    bookController.listAllBooks();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void userMenu(UserController userController, Scanner scanner) {
        while (true) {
            System.out.println("\nUsers Menu");
            System.out.println("1. List All Users");
            System.out.println("2. Add a User");
            System.out.println("3. View User Details");
            System.out.println("4. Update User Details");
            System.out.println("5. Delete a User");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Call a method to list all users from the UserController
                    break;
                case 2:
                    // Call a method to add a user from the UserController
                    break;
                case 3:
                    // Call a method to view user details from the UserController
                    break;
                case 4:
                    // Call a method to update user details from the UserController
                    break;
                case 5:
                    // Call a method to delete a user from the UserController
                    break;
                case 6:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }



}