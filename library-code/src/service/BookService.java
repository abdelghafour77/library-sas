

package service;

import model.Book;
import repository.BookRepository;

import java.sql.SQLOutput;
import java.util.ArrayList;
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

    public Book getBookById(int id) {
        return bookRepository.getBookById(id);
    }

    public void updateBook(int id, String title, String author) {
        bookRepository.updateBook(id, title, author);
    }

    public void deleteBook(int id) {
        // Check if the book exists
        Book existingBook = bookRepository.getBookById(id);
        if (existingBook != null) {
            bookRepository.deleteBook(id);
        } else {
            throw new IllegalArgumentException("Book with ID " + id + " not found.");
        }
    }
}