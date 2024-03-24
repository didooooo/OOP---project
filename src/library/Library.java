package library;

import author.Author;
import books.Books;
import sorting.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    List<Books> books = new ArrayList<>();

    public void booksAll() {
        if (!books.isEmpty()) {
            for (Books b : books) {
                System.out.printf("%s %s %s %s %d %.2f%n", b.getTitle(), b.getAuthor().toString(), b.getGenre(), b.getIsbn(),b.getYear(),b.getRating());
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
                    System.out.printf("%s %s %s %s%n Description:%n %s%n", b.getTitle(), b.getAuthor(), b.getIsbn(), b.getGenre(), b.getDescription());

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

    public void booksSort(int year) {
        GnomeSort sort = new YearSort();
        sort.gnomeSort(this.books);
    }

    public void booksSort(int year, String desc) {
        GnomeSort sort = new YearSort();
        sort.gnomeSort(books);
        Collections.reverse(books);
    }

    public void booksSort(String title) {
        GnomeSort sort = new TitleSort();
        sort.gnomeSort(books);
    }

    public void booksSort(String title, String desc) {
        GnomeSort sort = new TitleSort();
        sort.gnomeSort(books);
        Collections.reverse(books);
    }

    public void booksSort(Author author){
        GnomeSort sort = new AuthorSort();
        sort.gnomeSort(books);
    }
    public void booksSort(Author author, String desc){
        GnomeSort sort = new AuthorSort();
        sort.gnomeSort(books);
        Collections.reverse(books);
    }
    public void booksSort(double rating){
        GnomeSort sort = new RatingSort();
        sort.gnomeSort(books);
        Collections.reverse(books);
    }
    public void booksSort(double rating, String desc){
        GnomeSort sort = new RatingSort();
        sort.gnomeSort(books);
        Collections.reverse(books);
    }
    public void addBook(Books book){
        this.books.add(book);
    }
}
