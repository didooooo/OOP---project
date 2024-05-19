package library;

import author.Author;
import books.Book;
import books.Books;
import sorting.*;
import user.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Library class represents a library system that manages
 * books and provides various operations on them.
 */
public class Library {
    private Sorter sorter;
    private User user;
    List<Books> books = new ArrayList<>();
    private String path;

    public Library(Sorter sorter, User user) {
        this.sorter = sorter;
        this.user = user;
        path = null;
    }

    /**
     * Retrieves the path of the library.
     *
     * @return The path of the library.
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path of the library.
     *
     * @param path The path to be set.
     */
    public void setPath(String path) {
        this.path = path;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Sorter getSorter() {
        return sorter;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    /**
     * Displays information about all the books in the library.
     */
    public void booksAll() {
        if (!books.isEmpty()) {
            for (Books b : books) {
                System.out.printf("Title: %s |Author: %s |Genre: %s |ISBN: %s |Year: %d| Rating: %.2f%n", b.getTitle(), b.getAuthor().toString(), b.getGenre(), b.getIsbn(), b.getYear(), b.getRating());
            }
        }
    }

    /**
     * Displays information about a book based on its ISBN.
     *
     * @param isbn The ISBN of the book.
     */
    public void booksInfo(String isbn) {
        if (!books.isEmpty()) {
            for (Books b : books) {
                if (b.getIsbn().equalsIgnoreCase(isbn)) {
                    System.out.printf("Title: %s Author: %s Genre: %s ISBN: %s Year: %d %.2f%n", b.getTitle(), b.getAuthor().toString(), b.getGenre(), b.getIsbn(), b.getYear(), b.getRating());
                }
            }
        }
    }

    /**
     * Finds books based on a specified title.
     *
     * @param title The title of the book to search for.
     */
    public void booksFindTitle(String title) {
        if (!books.isEmpty()) {
            for (Books b : books) {
                if (b.getTitle().equalsIgnoreCase(title)) {
                    System.out.printf("Title: %s Author: %s Genre: %s ISBN: %s Year: %d %.2f%n", b.getTitle(), b.getAuthor().toString(), b.getGenre(), b.getIsbn(), b.getYear(), b.getRating());
                }
            }
        }
    }

    /**
     * Finds books based on a specified tag.
     *
     * @param tag The tag to search for.
     */
    public void booksFindTag(String tag) {
        if (!books.isEmpty()) {
            for (Books b : books) {
                if (b.getTags().contains(tag.toLowerCase())) {
                    System.out.printf("Title: %s Author: %s Genre: %s ISBN: %s Year: %d %.2f%n", b.getTitle(), b.getAuthor().toString(), b.getGenre(), b.getIsbn(), b.getYear(), b.getRating());
                }
            }
        }
    }

    public void booksFindAuthor(Author author) {
        if (!books.isEmpty()) {
            for (Books b : books) {
                if (b.getAuthor().equals(author)) {
                    System.out.printf("Title: %s Author: %s Genre: %s ISBN: %s Year: %d %.2f%n", b.getTitle(), b.getAuthor().toString(), b.getGenre(), b.getIsbn(), b.getYear(), b.getRating());
                }
            }
        }
    }

    /**
     * Sorts the books in the library based on the specified option (e.g., title, author, rating, year).
     *
     * @param option The option based on which the books are sorted.
     */
    public void booksSort(String option) {
        if ("title".equalsIgnoreCase(option)) {
            sorter.sortTitle(this.books);
        } else if ("author".equalsIgnoreCase(option)) {
            sorter.sortAuthor(this.books);
        } else if ("rating".equalsIgnoreCase(option)) {
            sorter.sortRating(this.books);
        } else if ("year".equalsIgnoreCase(option)) {
            sorter.sortYear(this.books);
        }
    }

    /**
     * Sorts the books in the library based on the specified option in descending order.
     *
     * @param option The option based on which the books are sorted.
     * @param desc   The sort order, which is not used in this method but maintained for consistency.
     */
    public void booksSort(String option, String desc) {
        booksSort(option);
        Collections.reverse(books);
    }

    /**
     * Adds a book to the library.
     *
     * @param book The book to be added.
     */
    public void addBook(Books book) {
        this.books.add(book);
    }

    /**
     * Removes a book from the library based on the specified ISBN.
     *
     * @param isbn The ISBN of the book to be removed.
     */
    public void removeBook(String isbn) {
        Books bookSaved = null;
        for (Books book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                bookSaved = book;
                break;
            }
        }
        if (bookSaved != null) {
            books.remove(bookSaved);
        }
    }


}
