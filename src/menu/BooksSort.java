package menu;

import library.Library;
import user.User;

import java.util.Scanner;
/**
 * Sorts books by a specified attribute if the user is logged in.
 *
 */
public class BooksSort implements MenuCommand{
    private Library lib;

    public BooksSort(Library lib) {
        this.lib = lib;
    }

    @Override
    public void execute(String[] data, User... user) {
        if (user[1].getUsername()!=null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose option(author,title,year,rating): ");
            String line = scanner.nextLine();
            line = line.toLowerCase();
            lib.booksSort(line);
            return;
        }
        throw  new RuntimeException("Need to log in first");
    }
}
