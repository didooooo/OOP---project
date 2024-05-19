package filesOperation;

import books.Books;
import library.Library;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class SaveAsFile {
    private Library library;

    public SaveAsFile(Library library) {
        this.library = library;
    }

    /**
     * Saves the library's data to the specified file path.
     * If the file does not exist, it creates a new file.
     *
     * @param path the path of the file to save the library's data to.
     */
    public void save(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        library.setPath(path);
        SaveFile.writeBooks(library);
        System.out.println("Successfully saved another " + path);
    }
}
