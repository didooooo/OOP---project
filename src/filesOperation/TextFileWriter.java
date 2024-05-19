package filesOperation;

import books.Books;
import library.Library;
import user.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * The TextFileWriter class implements the Writer interface and is responsible for writing
 * user data, a map of user key-value pairs, and library book data to a text file.
 */
public class TextFileWriter implements Writer {
    private final String FILE_PATH = "Users.txt";

    /**
     * Writes a user's username and password to the specified file path.
     *
     * @param path the path of the file to write the user's data to.
     * @param user the user whose data will be written to the file.
     */
    @Override
    public void write(String path, User user) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true)) {
            fileWriter.write(user.getUsername() + " " + user.getPassword() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes a map of user key-value pairs to the specified file path.
     * This method overwrites the existing content in the file.
     *
     * @param path  the path of the file to write the user key-value pairs to.
     * @param users the map of user key-value pairs to be written to the file.
     */
    @Override
    public void write(String path, Map<String, String> users) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, false)) {
            for (Map.Entry<String, String> kvp : users.entrySet()) {
                fileWriter.write(kvp.getKey() + " " + kvp.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(String path, Library library) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, false)) {
            for (Books book : library.getBooks()) {
                fileWriter.write(book.getTitle() + " " + book.getAuthor() + " ");
                fileWriter.write(book.getYear() + " ");
                fileWriter.write(book.getDescription() + " ");
                fileWriter.write(book.getIsbn() + " ");
                fileWriter.write(book.getRating() + " ");
                fileWriter.write(book.getGenre());
                fileWriter.write(System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
