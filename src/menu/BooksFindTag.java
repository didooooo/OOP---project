package menu;

import author.Author;
import library.Library;
import user.User;
/**
 * Finds books by tag if the user is logged in.
 *
 */
public class BooksFindTag implements MenuCommand{
    private Library lib;

    public BooksFindTag(Library lib) {
        this.lib = lib;
    }

    @Override
    public void execute(String[] data, User... user) {
        if (user[1].getUsername()!=null) {
            lib.booksFindTag(data[3]);
            return;
        }
        throw  new RuntimeException("Need to log in first");
    }
}
