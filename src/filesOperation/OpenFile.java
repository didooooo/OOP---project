package filesOperation;

import author.Author;
import books.Book;
import library.Library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
/**
 * The OpenFile class is responsible for handling file operations related to reading
 * book data from a specified file and updating the library accordingly.
 */
public class OpenFile{
    private Library library;

    /**
     * Constructs an OpenFile instance with the specified library.
     *
     * @param library the library to be updated with the data read from the file.
     */
    public OpenFile(Library library) {
        this.library = library;
    }
    /**
     * Reads book data from the specified file and updates the library with the data.
     * If the file does not exist, it creates a new file.
     *
     * @param filename the name of the file to read data from.
     */
    public void read(String filename){
        File file = new File(filename);
        if(!file.exists()){
            try {
                file.createNewFile();
                library.setPath(filename);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        try (FileReader fileReader = new FileReader(file)){
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split("==");
                Author author = new Author(tokens[2], tokens[3]);
                Book book  = new Book(author,tokens[4],tokens[5],tokens[6],Double.parseDouble(tokens[1]),tokens[7],Integer.parseInt(tokens[0]));
                String[] tags = scanner.nextLine().split("==");
                for (String tag : tags) {
                    book.addTag(tag.toLowerCase());
                }
                library.addBook(book);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        library.setPath(filename);
    }
}
