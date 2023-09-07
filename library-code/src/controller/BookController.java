package controller;

import model.Book;
import repository.BookRepository;
import service.BookService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookController {
    private static BookService bookService;
    private Connection connection;
    private static final Scanner scanner = new Scanner(System.in);


    public static void listAllBooks() {
        System.out.println("\nList All Books :");

        List<Book> books = new ArrayList<>();
        books = BookRepository.getAllBooks();

        for (Book book : books) {
            System.out.println(book.toString()+"\n");
        }

    }
    public static void addBook() {
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter the id_author of the book: ");
        int author_id =Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the isbn of the book: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter the quantity of the book: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        BookService.createBook(new Book(1,author_id, title, isbn, quantity,quantity, null));
        System.out.println("Book added successfully.");
    }
    private void viewBookDetails() {
        System.out.print("Enter the ID of the book: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Book book = bookService.getBookById(id);
        if (book != null) {
            System.out.println("\nBook Details:");
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }
    private void updateBookDetails() {
        System.out.print("Enter the ID of the book to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Book existingBook = bookService.getBookById(id);
        if (existingBook != null) {
            System.out.print("Enter the new title of the book: ");
            String newTitle = scanner.nextLine();
            System.out.print("Enter the new author of the book: ");
            String newAuthor = scanner.nextLine();

            bookService.updateBook(id, newTitle, newAuthor);
            System.out.println("Book details updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
    private void deleteBook() {
        System.out.print("Enter the ID of the book to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Book existingBook = bookService.getBookById(id);
        if (existingBook != null) {
            bookService.deleteBook(id);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);
        //BookController bookController = new BookController(bookService);
    //    bookController.start();
    }
}
