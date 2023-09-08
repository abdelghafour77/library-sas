import controller.AuthorController;
import controller.BookController;
import controller.BorrowController;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

    private static void bookMenu( Scanner scanner) {
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
            scanner.nextLine(); // Consume the newline character

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
                    return; // Return to the main menu
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
            System.out.println("2. List All the losted Books");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    BorrowController.searchBorrow("borrowed");
                    break;
                case 2:
                    BorrowController.searchBorrow("returned");
                    break;
                case 3:
                    BorrowController.searchBorrow("lost");
                    break;
                case 4:
                    // Call a method to return a book from the ReturnedBookController
                    break;
                case 5:
                    // Call a method to delete a book from the ReturnedBookController
                    break;
                case 6:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }



}