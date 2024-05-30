package menu;

import library.Library;
import user.User;
/**
 * Displays information about a specific book if the user is logged in.
 *
 */
public class BooksInfo implements MenuCommand{
    private Library lib;

    public BooksInfo(Library lib) {
        this.lib = lib;
    }

    @Override
    public void execute(String[] data, User... user) {
        if (user[1].getUsername()!=null) {
            lib.booksInfo(data[2]);
            return;
        }
        throw new RuntimeException("Need to login first");
    }
}
