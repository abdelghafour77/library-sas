

package service;

import model.Book;
import repository.BookRepository;

import java.util.List;

public class BookService {
    private static BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        BookService.bookRepository = bookRepository;
    }

    public static String createBook(Book book) {

        // check if the book already exists
        Book existingBook = BookRepository.getBookByIsbn(book.getIsbn());
        if (existingBook != null) {
            return "Book with ISBN " + book.getIsbn() + " already exists.";
        }
        if (BookRepository.createBook(book)) {
            return "Book added successfully.";
        } else {
            return "Book not added.";
        }
    }

    public static List<Book> getAllBooks() {
        return BookRepository.getAllBooks();
    }

    public static Book getBookById(int id) {
        return BookRepository.getBookById(id);
    }

    public static Book getBookByIsbn(String isbn) {
        return BookRepository.getBookByIsbn(isbn);
    }

    public static List<Book> searchBook(String title) {
        return BookRepository.searchBook(title);
    }

    public static String updateBook(Book book) {
        String message = "";
        // check if the book exists
        Book existingBook = BookRepository.getBookByIsbn(book.getIsbn());
        if (existingBook != null) {
            if (BookRepository.updateBook(book)) {
                message = "Book updated successfully.";
            } else {
                message = "Book not updated.";
            }
        } else {
            message = "Book not found.";
        }
        return message;
    }

    public static String deleteBook(String ISBN) {
        // check if the book exists
        Book existingBook = BookRepository.getBookByIsbn(ISBN);
        if (existingBook != null) {
            if (BookRepository.deleteBook(ISBN)) {
                return "Book deleted successfully.";
            } else {
                return "Book not deleted.";
            }
        } else {
            return "Book not found.";
        }
    }
}