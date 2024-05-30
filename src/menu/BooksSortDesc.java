package menu;

import library.Library;
import user.User;

import java.util.Scanner;
/**
 * Sorts books by a specified attribute in descending order if the user is logged in.
 *
 */
public class BooksSortDesc implements MenuCommand{
    private Library library;

    public BooksSortDesc(Library library) {
        this.library = library;
    }

    @Override
    public void execute(String[] data, User... user) {
        if (user[1].getUsername()!=null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose option(author,title,year,rating): ");
            String line = scanner.nextLine();
            line = line.toLowerCase();
            library.booksSort(line, data[2]);
            return;
        }
        throw new RuntimeException("Need to log in first");
    }
}
