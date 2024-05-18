package menu;

import author.Author;
import books.Book;
import user.User;

import java.util.Scanner;

public class CommandImpl implements Command {
    private final Controller controller;
    private Scanner scanner;

    public CommandImpl(Controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void booksAll(String[] data, User... user) {
        if (controller.isLoggedIn()) {
            controller.booksAll();
            return;
        }
        System.out.println("Need to log in first");
    }

    @Override
    public void booksInfo(String[] data, User... user) {
        if (controller.isLoggedIn()) {
            controller.booksInfo(data[1]);
            return;
        }
        System.out.println("Need to log in first");
    }

    @Override
    public void booksFindTitle(String[] data, User... user) {
        if (controller.isLoggedIn()) {
            controller.booksFindTitle(data[3]);
            return;
        }
        System.out.println("Need to log in first");

    }

    @Override
    public void booksFindAuthor(String[] data, User... user) {
        if (controller.isLoggedIn()) {
            controller.booksFindAuthor(new Author(data[3], data[4]));
            return;
        }
        System.out.println("Need to log in first");
    }

    @Override
    public void booksFindTag(String[] data, User... user) {
        if (controller.isLoggedIn()) {
            controller.booksFindTag(data[3]);
            return;
        }
        System.out.println("Need to log in first");
    }

    @Override
    public void booksSort(String[] data, User... user) {
        if (controller.isLoggedIn()) {
            controller.booksSort(data[1]);
            return;
        }
        System.out.println("Need to log in first");
    }

    @Override
    public void booksSortDesc(String[] data, User... user) {
        if (controller.isLoggedIn()) {
            controller.booksSort(data[1], data[1]);
            return;
        }
        System.out.println("Need to log in first");

    }

    @Override
    public void addBook(String[] data, User... user) {
        if (!controller.isAdmin()) {
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

    @Override
    public void removeBook(String[] data, User... user) {
        if (controller.isAdmin()) {
            controller.removeBook(data[1]);
            return;
        }
        System.out.println("Need admin to remove a book");
    }

    @Override
    public boolean login(String[] data, User... user) {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        return controller.login(user[0], username, password);
    }

    @Override
    public void logout(String[] data, User... user) {
        if (controller.isLoggedIn()) {
            controller.logout(user[0]);
            return;
        }
        System.out.println("Need to log in first");
    }

    @Override
    public void add(String[] data, User... user) {
        if (controller.isAdmin()) {
            controller.add(user[0]);
            return;
        }
        System.out.println("Need admin to add an user");
    }

    @Override
    public void remove(String[] data, User... user) {
        if (controller.isAdmin()) {
            controller.remove(user[0]);
            return;
        }
        System.out.println("Need admin to remove a user");
    }

    @Override
    public void save(String[] data, User... user) {
        controller.save();
    }

    @Override
    public void saveAs(String[] data, User... user) {
        controller.save(data[1]);
    }

    @Override
    public void open(String[] data, User... user) {
        controller.open(data[1]);
    }

    @Override
    public void close(String[] data, User... user) {
        controller.close();
    }
}
