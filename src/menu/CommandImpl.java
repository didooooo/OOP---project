package menu;

import author.Author;
import books.Book;
import user.User;

import javax.swing.*;
import javax.swing.text.PasswordView;
import java.awt.*;
import java.io.Console;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

/**
 * The CommandImpl class implements the Command interface,
 * providing concrete implementations
 * for various commands related to books and users.
 */
public class CommandImpl implements Command {
    private final Controller controller;
    private Scanner scanner;

    public CommandImpl(Controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays all books if the user is logged in.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void booksAll(String[] data, User... user) {
        if (controller.isLoggedIn(user[0])) {
            controller.booksAll();
            return;
        }
        System.out.println("Need to log in first");
    }

    /**
     * Displays information about a specific book if the user is logged in.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void booksInfo(String[] data, User... user) {
        if (controller.isLoggedIn(user[0])) {
            controller.booksInfo(data[2]);
            return;
        }
        System.out.println("Need to log in first");
    }

    /**
     * Finds books by title if the user is logged in.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void booksFindTitle(String[] data, User... user) {
        if (controller.isLoggedIn(user[0])) {
            StringBuilder sb = new StringBuilder();
            for (int i = 3; i < data.length - 1; i++) {
                sb.append(data[i]).append(" ");
            }
            sb.append(data[data.length - 1]);
            controller.booksFindTitle(sb.toString());
            return;
        }
        System.out.println("Need to log in first");

    }

    /**
     * Finds books by author if the user is logged in.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void booksFindAuthor(String[] data, User... user) {
        if (controller.isLoggedIn(user[0])) {
            controller.booksFindAuthor(new Author(data[3], data[4]));
            return;
        }
        System.out.println("Need to log in first");
    }

    /**
     * Finds books by tag if the user is logged in.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void booksFindTag(String[] data, User... user) {
        if (controller.isLoggedIn(user[0])) {
            controller.booksFindTag(data[3]);
            return;
        }
        System.out.println("Need to log in first");
    }

    /**
     * Sorts books by a specified attribute if the user is logged in.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void booksSort(String[] data, User... user) {
        if (controller.isLoggedIn(user[0])) {
            System.out.println("Choose option(author,title,year,rating): ");
            String line = scanner.nextLine();
            line = line.toLowerCase();
            controller.booksSort(line);
            return;
        }
        System.out.println("Need to log in first");
    }

    /**
     * Sorts books by a specified attribute in descending order if the user is logged in.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void booksSortDesc(String[] data, User... user) {
        if (controller.isLoggedIn(user[0])) {
            System.out.println("Choose option(author,title,year,rating): ");
            String line = scanner.nextLine();
            line = line.toLowerCase();
            controller.booksSort(line, data[2]);
            return;
        }
        System.out.println("Need to log in first");

    }

    /**
     * Adds a new book if the user is an admin.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void addBook(String[] data, User... user) {
        if (!controller.isAdmin(user[0])) {
            System.out.println("Need admin to add a book");
            return;
        }

        System.out.println("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.println("Enter the author of the book: ");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.println();
        System.out.print("Lats name: ");
        String lastName = scanner.nextLine();
        Author author = new Author(firstName, lastName);
        System.out.println("Enter the isbn of the book: ");
        String isbn = scanner.nextLine();
        System.out.println("Enter the year of the book: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the rating of the book: ");
        double rating = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the genre of the book: ");
        String genre = scanner.nextLine();
        System.out.println("Enter the description of the book: ");
        String description = scanner.nextLine();
        System.out.println("Enter the tags of the book, using \" \" for separator ");
        String[] split = scanner.nextLine().split("\\s+");
        Book book = new Book(author, title, genre, description, rating, isbn, year);
        for (String s : split) {
            book.addTag(s);
        }


        controller.addBook(book);
    }

    /**
     * Removes a book if the user is an admin.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void removeBook(String[] data, User... user) {
        if (controller.isAdmin(user[0])) {
            controller.removeBook(data[1]);
            return;
        }
        System.out.println("Need admin to remove a book");
    }

    /**
     * Logs in a user with the provided username and password.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     * @return true if login is successful, false otherwise.
     */
    @Override
    public boolean login(String[] data, User... user) {
        if (controller.isLoggedIn(user[0])) {
            System.out.println("Already have a user");
            return true;
        }
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        //String password = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] input = console.readPassword();
        for (char c : input) {
            if (c == '\n' || c == '\r') {
                sb.toString();
                break;
            }
            System.out.print("*");
            sb.append(c);
        }
        System.out.println();
        String password = sb.toString();
        return controller.login(user[0], username, password);
    }

    /**
     * Logs out the current user.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void logout(String[] data, User... user) {
        if (controller.isLoggedIn(user[0])) {
            controller.logout(user[0]);
            return;
        }
        System.out.println("Need to log in first");
    }

    /**
     * Adds a new user if the current user is an admin.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void add(String[] data, User... user) {

        if (controller.isAdmin(user[0])) {
            Console console = System.console();
            if (console == null) {
                System.out.println("Couldn't get Console instance");
                System.exit(0);
            }
            System.out.println("Enter username: ");
            String username = scanner.nextLine();
            System.out.println("Enter password: ");
            // String password = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            char[] input = console.readPassword();
            for (char c : input) {
                if (c == '\n' || c == '\r') {
                    sb.toString();
                    break;
                }
                System.out.print("*");
                sb.append(c);
            }
            System.out.println();
            String password = sb.toString();
            user[1].setUsername(username);
            user[1].setPassword(password);
            controller.add(user[1]);
            return;
        }
        System.out.println("Need admin to add an user");
    }

    /**
     * Removes a user if the current user is an admin.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void remove(String[] data, User... user) {
        if (controller.isAdmin(user[0])) {
            System.out.println("Enter username: ");
            String username = scanner.nextLine();
            user[1].setUsername(username);
            controller.remove(user[1]);
            return;
        }
        System.out.println("Need admin to remove a user");
    }

    /**
     * Saves the current state.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void save(String[] data, User... user) {
        controller.save();
    }

    /**
     * Saves the current state to a specified file path.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void saveAs(String[] data, User... user) {
        controller.save(data[1]);
    }

    /**
     * Opens a file from a specified file path.
     *
     * @param data the command data.
     * @param user the user attempting the command.
     */
    @Override
    public void open(String[] data, User... user) {
        controller.open(data[1]);
    }

    @Override
    public void close(String[] data, User... user) {
        controller.close();
    }

    @Override
    public void help(String[] data, User... user) {
        this.controller.help();
    }
}
