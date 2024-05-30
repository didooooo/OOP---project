package menu;

import books.Books;
import filesOperation.*;
import help.HelpCommand;
import library.Library;
import logger.LogOperation;
import logger.Logger;
import register.Register;
import register.RegisterOperation;
import user.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The EngineImpl class implements the Engine interface, providing a mechanism
 * to run the application and process user commands.
 */
public class EngineImpl implements Engine {
    private final Scanner scanner;
    private final Map<String, MenuCommand> menuCommands;
    private final Library library;
    private final LogOperation logOperation;
    private final RegisterOperation registerOperation;

    public EngineImpl(Scanner scanner, Library library, LogOperation logOperation, RegisterOperation registerOperation) {
        this.scanner = scanner;
        this.library = library;
        this.logOperation = logOperation;
        this.registerOperation = registerOperation;
        this.menuCommands = new HashMap<>();
    }

    /**
     * Runs the application, processing user commands until the "exit" command is entered.
     * This method also handles command invocation based on user input.
     */
    @Override
    public void run() {
        try {
            User user = new User();
            fillMapWithCommands();
            menuCommands.get("help").execute(null, user);
            while (true) {
                System.out.println("Next command: ");
                String line = scanner.nextLine();
                String[] tokens = line.split("\\s+");
                if (tokens[0].equals("exit")) {
                    break;
                }
                if (tokens.length >= 3) {
                    if (menuCommands.containsKey(tokens[0] + " " + tokens[1] + " " + tokens[2])) {
                        menuCommands.get(tokens[0] + " " + tokens[1] + " " + tokens[2]).execute(tokens, new User[]{user, library.getUser()});
                    } else {
                        checkValue(user, tokens);
                    }
                } else if (tokens.length == 2) {
                    checkValue(user, tokens);
                } else {
                    if (menuCommands.containsKey(tokens[0])) {
                        menuCommands.get(tokens[0]).execute(tokens, new User[]{user, library.getUser()});
                    } else {
                        System.out.println("Wrong command");
                    }
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks the user input against the stored commands and invokes the corresponding method.
     *
     * @param user   the User instance representing the current user.
     * @param tokens an array of strings representing the user input tokens.
     * @throws IllegalAccessException    if access to the method is denied.
     * @throws InvocationTargetException if the method cannot be invoked.
     */
    private void checkValue(User user, String[] tokens) throws IllegalAccessException, InvocationTargetException {
        if (menuCommands.containsKey(tokens[0] + " " + tokens[1])) {
            menuCommands.get(tokens[0] + " " + tokens[1]).execute(tokens, new User[]{user, library.getUser()});
        } else if (menuCommands.containsKey(tokens[0])) {
            menuCommands.get(tokens[0]).execute(tokens, new User[]{user, library.getUser()});
        } else {
            System.out.println("Wrong command");
        }
    }

    /**
     * Fills the map with commands mapped to their corresponding methods.
     *
     * @throws NoSuchMethodException if a specified method cannot be found.
     */
    private void fillMapWithCommands() throws NoSuchMethodException {
        MenuCommand booksAll = new BooksAll(library);
        MenuCommand booksInfo = new BooksInfo(library);
        MenuCommand login = new Login(logOperation);
        MenuCommand logout = new Logout(logOperation);
        MenuCommand removeBook = new RemoveBook(library);
        MenuCommand addBook = new AddBook(library);
        MenuCommand removeUser = new RemoveUser(registerOperation);
        MenuCommand addUser = new AddUser(registerOperation);
        MenuCommand booksFindTag = new BooksFindTag(library);
        MenuCommand booksFindAuthor = new BooksFindAuthor(library);
        MenuCommand booksFindTitle = new BooksFindTitle(library);
        MenuCommand booksSort = new BooksSort(library);
        MenuCommand booksSortDesc = new BooksSortDesc(library);
        MenuCommand close = new Close(new CloseFIle(library));
        MenuCommand help = new Help(new HelpCommand());
        MenuCommand open = new Open(new OpenFile(library));
        MenuCommand save = new Save(new SaveFile(library));
        MenuCommand saveas = new SaveAs(new SaveAsFile(library));
        menuCommands.put("books all", booksAll);
        menuCommands.put("login", login);
        menuCommands.put("logout", logout);
        menuCommands.put("books sort desc", booksSortDesc);
        menuCommands.put("books sort", booksSort);
        menuCommands.put("books find tag", booksFindTag);
        menuCommands.put("books find author", booksFindAuthor);
        menuCommands.put("books find title", booksFindTitle);
        menuCommands.put("books add", addBook);
        menuCommands.put("users add", addUser);
        menuCommands.put("users remove", removeUser);
        menuCommands.put("close", close);
        menuCommands.put("open", open);
        menuCommands.put("books info", booksInfo);
        menuCommands.put("books remove", removeBook);
        menuCommands.put("save", save);
        menuCommands.put("saveas", saveas);
        menuCommands.put("help", help);
    }
}
