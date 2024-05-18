package filesOperation;

import books.Books;
import library.Library;
import user.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class TextFileWriter implements Writer {
    private final String FILE_PATH = "Users.txt";

    @Override
    public void write(String path,User user) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true)) {
            fileWriter.write(user.getUsername() + " " + user.getPassword() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
                fileWriter.write(book.getTitle()+ " " + book.getAuthor() +" ");
                fileWriter.write(book.getYear() + " ");
                fileWriter.write(book.getDescription() + " ");
                fileWriter.write(book.getIsbn()+" ");
                fileWriter.write( book.getRating()+" ");
                fileWriter.write(book.getGenre());
                fileWriter.write(System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
