package books;

import author.Author;

import java.util.HashSet;
import java.util.Set;

public class Book extends Books {
    /**
     * Constructs a Book instance with the specified author, title, genre, description,
     * rating, ISBN, and year of publication.
     *
     * @param author      the author of the book.
     * @param title       the title of the book.
     * @param genre       the genre of the book.
     * @param description a brief description of the book.
     * @param rating      the rating of the book.
     * @param isbn        the ISBN of the book.
     * @param year        the year the book was published.
     */
    public Book(Author author, String title, String genre, String description, double rating, String isbn, int year) {
        super(author, title, genre, description, rating, isbn, year);
    }
}
