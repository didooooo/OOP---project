package library;

import author.Author;
import books.Book;
import books.Books;
import sorting.*;
import user.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private Sorter sorter;
    private User user;
    List<Books> books = new ArrayList<>();
    private String path;

    public Library(Sorter sorter, User user) {
        this.sorter = sorter;
        this.user = user;
        path= null;
    }

    public String getPath() {
        return path;
    }

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

    public void booksAll() {
        if (!books.isEmpty()) {
            for (Books b : books) {
                System.out.printf("%s %s %s %s %d %.2f%n", b.getTitle(), b.getAuthor().toString(), b.getGenre(), b.getIsbn(), b.getYear(), b.getRating());
            }
        }
    }

    public void booksInfo(String isbn) {
        if (!books.isEmpty()) {
            for (Books b : books) {
                if (b.getIsbn().equalsIgnoreCase(isbn)) {
                    System.out.printf("%s %s %s %s%n Description:%n %s%n", b.getTitle(), b.getAuthor(), b.getIsbn(), b.getGenre(), b.getDescription());
                }
            }
        }
    }

    public void booksFindTitle(String title) {
        if (!books.isEmpty()) {
            for (Books b : books) {
                if (b.getTitle().equalsIgnoreCase(title)) {
                    System.out.printf("%s %s %s %s%n Description:%n %s%n", b.getTitle(), b.getAuthor(), b.getIsbn(), b.getGenre(), b.getDescription());

                }
            }
        }
    }

    public void booksFindTag(String tag) {
        if (!books.isEmpty()) {
            for (Books b : books) {
                if (b.getTags().contains(tag.toLowerCase())) {
                    System.out.printf("%s %s %s %s%n Description:%n %s%nTag: %s%n", b.getTitle(), b.getAuthor(), b.getIsbn(), b.getGenre(), b.getDescription(),tag);

                }
            }
        }
    }

    public void booksFindAuthor(Author author) {
        if (!books.isEmpty()) {
            for (Books b : books) {
                if (b.getAuthor().equals(author)) {
                    System.out.printf("%s %s %s %s%n Description:%n %s%n", b.getTitle(), b.getAuthor(), b.getIsbn(), b.getGenre(), b.getDescription());
                }
            }
        }
    }
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

    public void booksSort(String option, String desc) {
        booksSort(option);
        Collections.reverse(books);
    }

    public void addBook(Books book) {
        this.books.add(book);
    }

    public void removeBook(String isbn) {
        Books bookSaved = null;
        for (Books book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                bookSaved = book;
                break;
            }
        }
        if(bookSaved != null) {
            books.remove(bookSaved);
        }
    }


}
