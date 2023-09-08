

package service;

import model.Book;
import repository.BookRepository;

import java.util.List;

public class BookService {
    private static BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        BookService.bookRepository = bookRepository;
    }

    public static void createBook(Book book) {
        bookRepository.createBook(book);
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

    public static Book updateBook(Book book) {
        return BookRepository.updateBook(book);
    }

    public static void deleteBook(int id) {
        // Check if the book exists
        Book existingBook = BookRepository.getBookById(id);
        if (existingBook != null) {
            BookRepository.deleteBook(id);
        } else {
            throw new IllegalArgumentException("Book with ID " + id + " not found.");
        }
    }
}