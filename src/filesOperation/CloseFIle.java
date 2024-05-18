package filesOperation;

import library.Library;

public class CloseFIle {
    private Library library;
    public CloseFIle(Library library) {
        this.library = library;
    }
    public void close() {
        library.setPath(null);
    }
}
