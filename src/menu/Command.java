package menu;

import user.User;

public interface Command {
    void booksAll(String[] data, User... user);

    void booksInfo(String[] data, User... user);

    void booksFindTitle(String[] data, User... user);

    void booksFindAuthor(String[] data, User... user);

    void booksFindTag(String[] data, User... user);

    void booksSort(String[] data, User... user);

    void booksSortDesc(String[] data, User... user);

    void addBook(String[] data, User... user);

    void removeBook(String[] data, User... user);

    boolean login(String[] data, User... user);

    void logout(String[] data, User... user);

    void add(String[] data, User... user);

    void remove(String[] data, User... user);

    void save(String[] data, User... user);

    void saveAs(String[] data, User... user);

    void open(String[] data, User... user);

    void close(String[] data, User... user);
}
