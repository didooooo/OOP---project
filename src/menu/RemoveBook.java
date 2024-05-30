package menu;

import library.Library;
import user.User;
/**
 * Removes a book if the user is an admin.
 *
 */
public class RemoveBook implements MenuCommand{
    private Library library;

    public RemoveBook(Library library) {
        this.library = library;
    }

    @Override
    public void execute(String[] data, User... user) {
        if (user[1].isAdmin()) {
            library.removeBook(data[1]);
            return;
        }
        throw new RuntimeException("Need admin to remove a book");
    }
}
