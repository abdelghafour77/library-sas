package controller;

import model.Author;
import repository.AuthorRepository;
import service.AuthorService;


import java.util.List;
import java.util.Scanner;

public class AuthorController {
    private static final Scanner scanner = new Scanner(System.in);

    public static void listAllAuthors() {
        System.out.println("\nList All Authors :");
        List<Author> authors = AuthorService.getAllAuthors();

        for (Author author : authors) {
            System.out.println(author.toString() + "\n");
        }

    }

    public static void addAuthor() {
        System.out.print("Enter the name of the author: ");
        String name = scanner.nextLine();
        System.out.print("Enter the biography of the author: ");
        String biography = scanner.nextLine();

        AuthorService.createAuthor(new Author(1, name, biography, null, null));
        System.out.println("Author added successfully.");
    }

    public static void viewAuthorDetails() {
        System.out.print("Enter the ID of the author: ");
        int id = Integer.parseInt(scanner.nextLine());

        Author author = AuthorService.getAuthorById(id);
        if (author != null) {
            System.out.println("\nAuthor Details:");
            System.out.println(author.toString());
        } else {
            System.out.println("Author not found.");
        }
    }

    public static void updateAuthor() {
        System.out.print("Enter the ID of the author: ");
        int id = Integer.parseInt(scanner.nextLine());

        Author author = AuthorService.getAuthorById(id);
        if (author != null) {
            System.out.println("\nAuthor Details:");
            System.out.println(author.toString());

            while(true) {
                System.out.println("\nUpdate Menu");
                System.out.println("1. Update Name");
                System.out.println("2. Update Biography");
                System.out.println("3. Back to Author Menu");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter the new name of the author: ");
                        String name = scanner.nextLine();
                        author.setName(name);
                        AuthorService.updateAuthor(author);
                        System.out.println("Author updated successfully.");
                        break;
                    case 2:
                        System.out.print("Enter the new biography of the author: ");
                        String biography = scanner.nextLine();
                        author.setBiography(biography);
                        AuthorService.updateAuthor(author);
                        System.out.println("Author updated successfully.");
                        break;
                    case 3:
                        return; // Return to the author menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }



        } else {
            System.out.println("Author not found.");
        }
    }

    public static void deleteAuthor() {
        System.out.print("Enter the ID of the author: ");
        int id = Integer.parseInt(scanner.nextLine());

        Author author = AuthorService.getAuthorById(id);
        if (author != null) {
            System.out.println("\nAuthor Details:");
            System.out.println(author.toString());

            AuthorService.deleteAuthor(id);
            System.out.println("Author deleted successfully.");
        } else {
            System.out.println("Author not found.");
        }
    }

    public static void searchAuthor() {
        System.out.print("Enter the name of the author: ");
        String name = scanner.nextLine();

        Author author = AuthorService.getAuthorByName(name);
        if (author != null) {
            System.out.println("\nSearch Results:");
                System.out.println(author.toString());
        } else {
            System.out.println("No authors found.");
        }
    }
}
