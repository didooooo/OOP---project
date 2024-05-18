package menu;

import author.Author;
import books.Book;
import sorting.Sorter;
import user.User;

public interface Controller {
    void booksAll();

    void booksInfo(String isbn);

    void booksFindTitle(String title);

    void booksFindAuthor(Author author);

    void booksFindTag(String tag);

    void booksSort(String option);

    void booksSort(String option, String desc);

    void addBook(Book book);

    void removeBook(String isbn);

    void setSorter(Sorter sorter);

    boolean login(User user, String username, String password);

    void logout(User user);

    void add(User user);

    void remove(User user);

    void save();

    void save(String filename);

    void open(String filename);

    void close();

    boolean isLoggedIn();

    boolean isAdmin();
}
