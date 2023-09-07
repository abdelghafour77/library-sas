import controller.BookController;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Books");
            System.out.println("2. Users");
            System.out.println("3. Exit");
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
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete a Book");
            System.out.println("6. Statistics");
            System.out.println("7. Back to Main Menu");
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
                    BookController.updateBookDetails();
                    break;
                case 5:
                    BookController.deleteBook();
                    break;
                case 6:
                    BookController.statistics();
                    break;
                case 7:
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



}