package filesOperation;

import books.Books;
import library.Library;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

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
        System.out.println("Successfully saved "+library.getPath());
    }

    public static void writeBooks(Library library) {
        try (FileWriter fileWriter = new FileWriter(library.getPath())) {
            for (Books book : library.getBooks()) {
                fileWriter.write(book.getAuthor().getFirstName());
                fileWriter.write(" ");
                fileWriter.write(book.getAuthor().getLastName());
                fileWriter.write(" ");
                fileWriter.write(book.getTitle());
                fileWriter.write(" ");
                fileWriter.write(book.getGenre());
                fileWriter.write(" ");
                fileWriter.write(book.getDescription());
                fileWriter.write(" ");
                fileWriter.write(String.valueOf(book.getRating()));
                fileWriter.write(" ");
                fileWriter.write(book.getIsbn());
                fileWriter.write(" ");
                fileWriter.write(String.valueOf(book.getYear()));
                Set<String> tags = book.getTags();
                fileWriter.write(System.lineSeparator());
                for (String tag : tags) {
                    fileWriter.write(tag + " ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
