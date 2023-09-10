import controller.AuthorController;
import controller.BookController;
import controller.BorrowController;
import controller.UserController;
import model.Admin;
import model.Client;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to Library Management System");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Client user = UserController.login();
                    if (user != null) {
                        if (user.getIs_admin().equals("admin")) {
                            adminMenu(scanner, user);
                        } else {
                            clientMenu(scanner, user);
                        }
                    }
                    break;
                case 2:
                    Client client = UserController.addClient();
                    clientMenu(scanner, client);
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

    private static void adminMenu(Scanner scanner, Client user) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Books");
            System.out.println("2. Users");
            System.out.println("3. Borrowed & Return Books");
            System.out.println("4. Authors");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bookMenu(scanner);
                    break;
                case 2:
                    userMenu(scanner);
                    break;
                case 3:
                    borrowedMenu(scanner);
                    break;
                case 4:
                    authorMenu(scanner);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void clientMenu(Scanner scanner, Client user) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Books");
            System.out.println("2. My list of Borrowed & Return Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bookMenu(scanner);
                    break;
                case 2:
                    BorrowController.getBorrowByEmail(user.getEmail());
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

    private static void bookMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nBooks Menu");
            System.out.println("1. List All Books");
            System.out.println("2. Add a Book");
            System.out.println("3. Search for Book");
            System.out.println("4. View Book Details");
            System.out.println("5. Update Book Details");
            System.out.println("6. Delete a Book");
            System.out.println("7. Statistics");
            System.out.println("8. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    BookController.listAllBooks();
                    break;
                case 2:
                    BookController.addBook();
                    break;
                case 3:
                    BookController.searchBook();
                    break;
                case 4:
                    BookController.viewBookDetails();
                    break;
                case 5:
                    BookController.updateBookDetails();
                    break;
                case 6:
                    BookController.deleteBook();
                    break;
                case 7:
                    BookController.statistics();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void userMenu(Scanner scanner) {
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
                    UserController.listAllUsers();
                    break;
                case 2:
                    while (true) {
                        System.out.println("\nAdd a User");
                        System.out.println("1. Add an Admin");
                        System.out.println("2. Add a Client");
                        System.out.println("3. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        int choice1 = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice1) {
                            case 1:
                                UserController.addAdmin();
                                break;
                            case 2:
                                UserController.addClient();
                                break;
                            case 3:
                                return;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                case 3:
                    UserController.viewUserDetails();
                    break;
                case 4:
                    UserController.updateUserDetails();
                    break;
                case 5:
                    UserController.deleteUser();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void authorMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nAuthors Menu");
            System.out.println("1. List All Authors");
            System.out.println("2. Add an Author");
            System.out.println("3. View Author Details");
            System.out.println("4. Update Author Details");
            System.out.println("5. Delete an Author");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    AuthorController.listAllAuthors();
                    break;
                case 2:
                    AuthorController.addAuthor();
                    break;
                case 3:
                    AuthorController.viewAuthorDetails();
                    break;
                case 4:
                    AuthorController.updateAuthor();
                    break;
                case 5:
                    AuthorController.deleteAuthor();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void borrowedMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nBorrowed & Return Books Menu");
            System.out.println("1. List All Borrowed Books");
            System.out.println("2. List All Returned Books");
            System.out.println("3. List All the losted Books");
            System.out.println("4. Borrow a Book");
            System.out.println("5. Return a Book");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    BorrowController.searchBorrow("borrow");
                    break;
                case 2:
                    BorrowController.searchBorrow("return");
                    break;
                case 3:
                    BorrowController.searchBorrow("lost");
                    break;
                case 4:
                    BorrowController.addBorrow();
                    break;
                case 5:
                    BorrowController.addReturn();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


}