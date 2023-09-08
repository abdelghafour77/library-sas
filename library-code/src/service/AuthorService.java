package service;

import model.Author;
import repository.AuthorRepository;

import java.util.List;

public class AuthorService {

    private static AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        AuthorService.authorRepository = authorRepository;
    }

    public static List<Author> getAllAuthors() {
        return AuthorRepository.getAllAuthors();
    }

    public static void createAuthor(Author author) {
        AuthorRepository.createAuthor(author);
    }

    public static Author getAuthorById(int id) {
        return AuthorRepository.getAuthorById(id);
    }

    public static Author getAuthorByName(String name) {
        return AuthorRepository.getAuthorByName(name);
    }

    public static Author updateAuthor(Author author) {
        return AuthorRepository.updateAuthor(author);
    }

    public static void deleteAuthor(int id) {
        // Check if the author exists
        Author existingAuthor = AuthorRepository.getAuthorById(id);
        if (existingAuthor != null) {
            AuthorRepository.deleteAuthor(id);
        } else {
            throw new IllegalArgumentException("Author with ID " + id + " not found.");
        }
    }

}
