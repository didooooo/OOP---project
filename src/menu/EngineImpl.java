package menu;

import library.Library;
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
    private final Controller controller;
    private final Map<String, Method> menuCommands;
    private final Command command;
    private final Library library;

    public EngineImpl(Scanner scanner, Controller controller, Command command, Library library) {
        this.scanner = scanner;
        this.controller = controller;
        this.command = command;
        this.library = library;
        menuCommands = new HashMap<>();
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
            controller.help();
            while (true) {
                System.out.println("Next command: ");
                String line = scanner.nextLine();
                String[] tokens = line.split("\\s+");
                if (tokens[0].equals("exit")) {
                    break;
                }
                if (tokens.length >= 3) {
                    if (menuCommands.containsKey(tokens[0] + " " + tokens[1] + " " + tokens[2])) {
                        menuCommands.get(tokens[0] + " " + tokens[1] + " " + tokens[2]).invoke(command, tokens, new User[]{library.getUser(), user});
                    } else {
                        checkValue(user, tokens);
                    }
                } else if (tokens.length == 2) {
                    checkValue(user, tokens);
                } else {
                    if (menuCommands.containsKey(tokens[0])) {
                        menuCommands.get(tokens[0]).invoke(command, tokens, new User[]{library.getUser(), user});
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
            menuCommands.get(tokens[0] + " " + tokens[1]).invoke(command, tokens, new User[]{library.getUser(), user});
        } else if (menuCommands.containsKey(tokens[0])) {
            menuCommands.get(tokens[0]).invoke(command, tokens, new User[]{library.getUser(), user});
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
        Method method = CommandImpl.class.getMethod("booksAll", String[].class, User[].class);
        Method method1 = CommandImpl.class.getMethod("login", String[].class, User[].class);
        Method method2 = CommandImpl.class.getMethod("logout", String[].class, User[].class);
        Method method3 = CommandImpl.class.getMethod("booksSortDesc", String[].class, User[].class);
        Method method4 = CommandImpl.class.getMethod("booksSort", String[].class, User[].class);
        Method method5 = CommandImpl.class.getMethod("booksFindTag", String[].class, User[].class);
        Method method6 = CommandImpl.class.getMethod("addBook", String[].class, User[].class);
        Method method7 = CommandImpl.class.getMethod("booksFindAuthor", String[].class, User[].class);
        Method method8 = CommandImpl.class.getMethod("booksFindTitle", String[].class, User[].class);
        Method method9 = CommandImpl.class.getMethod("add", String[].class, User[].class);
        Method method10 = CommandImpl.class.getMethod("remove", String[].class, User[].class);
        Method method11 = CommandImpl.class.getMethod("close", String[].class, User[].class);
        Method method12 = CommandImpl.class.getMethod("open", String[].class, User[].class);
        Method method13 = CommandImpl.class.getMethod("save", String[].class, User[].class);
        Method method14 = CommandImpl.class.getMethod("saveAs", String[].class, User[].class);
        Method method15 = CommandImpl.class.getMethod("booksInfo", String[].class, User[].class);
        Method method16 = CommandImpl.class.getMethod("removeBook", String[].class, User[].class);
        Method method17 = CommandImpl.class.getMethod("help", String[].class, User[].class);
        menuCommands.put("books all", method);
        menuCommands.put("login", method1);
        menuCommands.put("logout", method2);
        menuCommands.put("books sort desc", method3);
        menuCommands.put("books sort", method4);
        menuCommands.put("books find tag", method5);
        menuCommands.put("books find author", method7);
        menuCommands.put("books find title", method8);
        menuCommands.put("books add", method6);
        menuCommands.put("users add", method9);
        menuCommands.put("users remove", method10);
        menuCommands.put("close", method11);
        menuCommands.put("open", method12);
        menuCommands.put("books info", method15);
        menuCommands.put("books remove", method16);
        menuCommands.put("save", method13);
        menuCommands.put("saveas", method14);
        menuCommands.put("help", method17);
    }
}
