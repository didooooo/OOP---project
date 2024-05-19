package filesOperation;

import library.Library;
/**
 * The CloseFile class is responsible for handling the closure of a file operation
 * by resetting the library's file path.
 */
public class CloseFIle {
    private Library library;
    public CloseFIle(Library library) {
        this.library = library;
    }
    public void close() {
        library.setPath(null);
    }
}
