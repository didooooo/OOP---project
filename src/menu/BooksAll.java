package menu;

import library.Library;
import user.User;
/**
 * Displays all books if the user is logged in.
 */
public class BooksAll implements MenuCommand {
    private Library lib;

    public BooksAll(Library lib) {
        this.lib = lib;
    }

    @Override
    public void execute(String[] data, User... user) {
        if (user[1].getUsername()!=null) {
            lib.booksAll();
            return;
        }
        throw new RuntimeException("Need to login first");
    }
}
