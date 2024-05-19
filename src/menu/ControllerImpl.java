package menu;

import author.Author;
import books.Book;
import filesOperation.CloseFIle;
import filesOperation.OpenFile;
import filesOperation.SaveAsFile;
import filesOperation.SaveFile;
import help.HelpCommand;
import library.Library;
import logger.LogOperation;
import register.RegisterOperation;
import sorting.Sorter;
import user.User;

/**
 * The ControllerImpl class implements the Controller interface, providing methods
 * to manage operations related to books, users, logging, registration, and file operations.
 */
public class ControllerImpl implements Controller {
    private Library library;
    private LogOperation logOperation;
    private RegisterOperation registerOperation;
    private OpenFile openFile;
    private CloseFIle closeFile;
    private SaveAsFile saveAsFile;
    private SaveFile saveFile;
    private HelpCommand helpCommand;

    public ControllerImpl(Library library, LogOperation logOperation, RegisterOperation registerOperation) {
        this.library = library;
        this.logOperation = logOperation;
        this.registerOperation = registerOperation;
        this.openFile = new OpenFile(library);
        this.closeFile = new CloseFIle(library);
        this.saveAsFile = new SaveAsFile(library);
        this.saveFile = new SaveFile(library);
        this.helpCommand = new HelpCommand();
    }

    @Override
    public void booksAll() {
        library.booksAll();
    }

    @Override
    public void booksInfo(String isbn) {
        library.booksInfo(isbn);
    }

    @Override
    public void booksFindTitle(String title) {
        library.booksFindTitle(title);
    }

    @Override
    public void booksFindAuthor(Author author) {
        library.booksFindAuthor(author);
    }

    @Override
    public void booksFindTag(String tag) {
        library.booksFindTag(tag);
    }

    @Override
    public void booksSort(String option) {
        library.booksSort(option);
    }

    @Override
    public void booksSort(String option, String desc) {
        library.booksSort(option, desc);
    }

    @Override
    public void addBook(Book book) {
        library.addBook(book);
    }

    @Override
    public void removeBook(String isbn) {
        library.removeBook(isbn);
    }

    @Override
    public void setSorter(Sorter sorter) {
        library.setSorter(sorter);
    }

    @Override
    public boolean login(User user, String username, String password) {
        return logOperation.login(user, username, password);
    }

    @Override
    public void logout(User user) {
        logOperation.logout(user);
    }

    @Override
    public void add(User user) {
        this.registerOperation.add(user);
    }

    @Override
    public void remove(User user) {
        this.registerOperation.remove(user);
    }

    @Override
    public void save() {
        this.saveFile.saveFile();
    }

    @Override
    public void save(String filename) {
        this.saveAsFile.save(filename);
    }

    @Override
    public void open(String filename) {
        this.openFile.read(filename);
    }

    @Override
    public void close() {
        this.closeFile.close();
    }

    @Override
    public boolean isLoggedIn(User user) {
        if (user.getUsername() == null) return false;
        return true;
    }

    @Override
    public boolean isAdmin(User user) {
        return user.isAdmin();
    }

    @Override
    public void help() {
        helpCommand.help();
    }
}
