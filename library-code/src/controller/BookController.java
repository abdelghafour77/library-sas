package controller;

import model.Book;
import repository.BookRepository;
import service.BookService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookController {
    private BookService bookService;
    private Connection connection;
    private Scanner scanner;

    public void listAllBooks() {
        System.out.println("\nList All Books :");
        BookService.getAllBooks();
        // CREATE FOR LOOP TO PRINT ALL BOOKS
       // bookService.getAllBooks();
       /* System.out.println(books.size());
        for (Book book : books) {
            System.out.println("\n\tId: "+book.getId()+" ISBN: "+book.getIsbn()+" Title: "+book.getTitle()+" Author: "+book.getAuthor_id()+" Quantity: "+book.getQuantity());
        }*/



    }
    private void addBook() {
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter the id_author of the book: ");
        int author_id = scanner.nextInt();
        System.out.print("Enter the isbn of the book: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter the quantity of the book: ");
        int quantity = scanner.nextInt();

        bookService.createBook(title, author_id, isbn, quantity);
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
