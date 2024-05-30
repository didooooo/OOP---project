package menu;

import library.Library;
import user.User;
/**
 * Finds books by title if the user is logged in.
 *
 */
public class BooksFindTitle implements MenuCommand{
    private Library lib;

    public BooksFindTitle(Library lib) {
        this.lib = lib;
    }

    @Override
    public void execute(String[] data, User... user) {
        if (user[1].getUsername()!=null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 3; i < data.length - 1; i++) {
                sb.append(data[i]).append(" ");
            }
            sb.append(data[data.length - 1]);
            lib.booksFindTitle(sb.toString());
            return;
        }
       throw  new RuntimeException("Need to log in first");
    }
}
