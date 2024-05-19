package filesOperation;

import books.Books;
import library.Library;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
/**
 * The SaveFile class is responsible for saving the library's data
 * to the file specified in the library's path.
 */
public class SaveFile {
    private Library library;

    public SaveFile(Library library) {
        this.library = library;
    }

    public void saveFile() {
        if (library.getPath() == null) {
            System.out.println("No file selected");
            return;
        }
        writeBooks(library);
        System.out.println("Successfully saved " + library.getPath());
    }

    /**
     * Saves the library's data to the file specified in the library's path.
     * If no file is selected, it prints a message indicating that no file is selected.
     */
    public static void writeBooks(Library library) {
        try (FileWriter fileWriter = new FileWriter(library.getPath())) {
            for (Books book : library.getBooks()) {
                fileWriter.write(String.valueOf(book.getYear()));
                fileWriter.write("==");
                fileWriter.write(String.valueOf(book.getRating()));
                fileWriter.write("==");
                fileWriter.write(book.getAuthor().getFirstName());
                fileWriter.write("==");
                fileWriter.write(book.getAuthor().getLastName());
                fileWriter.write("==");
                fileWriter.write(book.getTitle());
                fileWriter.write("==");
                fileWriter.write(book.getGenre());
                fileWriter.write("==");
                fileWriter.write(book.getDescription());
                fileWriter.write("==");
                fileWriter.write(book.getIsbn());
                Set<String> tags = book.getTags();
                fileWriter.write(System.lineSeparator());
                for (String tag : tags) {
                    fileWriter.write(tag + "==");
                }
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
