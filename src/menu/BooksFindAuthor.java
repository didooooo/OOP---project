package menu;

import author.Author;
import library.Library;
import user.User;
/**
 * Finds books by author if the user is logged in.
 *
 */
public class BooksFindAuthor implements MenuCommand{
    private Library library;

    public BooksFindAuthor(Library library) {
        this.library = library;
    }

    @Override
    public void execute(String[] data, User... user) {
        if (user[1].getUsername()!=null) {
            library.booksFindAuthor(new Author(data[3], data[4]));
            return;
        }
        throw  new RuntimeException("Need to log in first");
    }
}
