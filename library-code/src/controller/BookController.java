package controller;

import model.Book;
import model.Borrow;
import repository.BookRepository;
import repository.BorrowRepository;
import service.AuthorService;
import service.BookService;

import java.util.List;
import java.util.Scanner;

public class BookController {

    private static final Scanner scanner = new Scanner(System.in);


    public static void listAllBooks() {
        System.out.println("\nList All Books :");

        List<Book> books;
        books = BookService.getAllBooks();

        for (Book book : books) {
            System.out.println(book.toString() + "\n");
        }
    }

    public static void addBook() {
        // print all authors
        AuthorController.listAllAuthors();
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.println("Choose the author of the book by id: ");
        System.out.print("Enter the id_author of the book: ");
        int author_id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the isbn of the book: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter the quantity of the book: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println(
                BookService.createBook(
                        new Book(1, author_id, title, isbn, quantity, quantity, null)
                )
        );

    }

    public static void viewBookDetails() {
        System.out.print("Enter the ISBN of the book: ");
        String isbn = scanner.nextLine();

        Book book = BookService.getBookByIsbn(isbn);
        if (book != null) {
            System.out.println("\nBook Details:");
            System.out.println(book.toString());
        } else {
            System.out.println("Book not found.");
        }
    }

    public static void searchBook() {
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();

        List<Book> books = BookService.searchBook(title);
        if (books.size() > 0) {
            System.out.println("\nSearch Results:");
            for (Book book : books) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books found.");
        }
    }

    public static void updateBookDetails() {
        System.out.print("Enter the ID of the book to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book existingBook = BookService.getBookById(id);
        if (existingBook != null) {
            while (true) {
                System.out.println("the details of the book are :");
                System.out.println(existingBook.toString());

                System.out.println("1. Change the title");
                System.out.println("2. Change the author");
                System.out.println("3. Change the quantity");

                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the new title of the book: ");
                        String newTitle = scanner.nextLine();
                        existingBook.setTitle(newTitle);
                        break;
                    case 2:
                        AuthorController.listAllAuthors();
                        System.out.println("Choose the author of the book by id: ");
                        System.out.print("Enter the id_author of the book: ");
                        int author_id = Integer.parseInt(scanner.nextLine());
                        existingBook.setAuthor_id(author_id);
                        break;
                    case 3:
                        System.out.println("Enter the new quantity of the book: ");
                        int newQuantity = scanner.nextInt();
                        scanner.nextLine();
                        existingBook.setQuantity(newQuantity);
                        existingBook.setAvailable_quantity(newQuantity);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                System.out.println("Do you want to continue ? (y/n)");
                String choice2 = scanner.nextLine();
                if (choice2.equals("n")) {
                    break;
                }
            }
            System.out.println(BookService.updateBook(existingBook));

        } else {
            System.out.println("Book not found.");
        }
    }

    public static void deleteBook() {
        System.out.print("Enter the ISBN of the book to delete: ");
        String ISBN = scanner.nextLine();
        System.out.println(BookService.deleteBook(ISBN));
    }

    public static void statistics() {


        int borrow = BorrowRepository.getBorrowByStatus("borrow").size();
        int returnn = BorrowRepository.getBorrowByStatus("return").size();
        int lost = BorrowRepository.getBorrowByStatus("lost").size();

        System.out.println("the number of borrowed books is : " + borrow);
        System.out.println("the number of returned books is : " + returnn);
        System.out.println("the number of lost books is : " + lost);


    }


}
