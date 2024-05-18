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

public class OpenFile{
    private Library library;
    public OpenFile(Library library) {
        this.library = library;
    }
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
                String[] tokens = line.split("\\s+");
                Author author = new Author(tokens[0], tokens[1]);
                Book book  = new Book(author,tokens[2],tokens[3],tokens[4],Double.parseDouble(tokens[5]),tokens[6],Integer.parseInt(tokens[7]));
                String[] tags = scanner.nextLine().split("\\s+");
                for (String tag : tags) {
                    book.addTag(tag);
                }
                library.addBook(book);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
