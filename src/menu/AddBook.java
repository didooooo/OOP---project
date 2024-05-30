package menu;

import author.Author;
import books.Book;
import library.Library;
import user.User;

import java.util.Scanner;
/**
 * Adds a new book if the user is an admin.
 *
 */
public class AddBook implements MenuCommand {
    private Library library;

    public AddBook(Library library) {
        this.library = library;
    }

    @Override
    public void execute(String[] data, User... user) {
        if (!user[1].isAdmin()) {
            throw new RuntimeException("Need admin to add a book");
        }
        Scanner scanner = new Scanner(System.in);
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


        library.addBook(book);
    }
}
