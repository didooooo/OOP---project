package logger;

import filesOperation.Reader;
import user.User;

import java.io.Console;
import java.util.Map;

/**
 * The Logger class implements the LogOperation interface and handles user
 * login and logout operations.
 */
public class Logger implements LogOperation {
    private final Reader reader;
    private final String FILE_PATH = "Users.txt";

    public Logger(Reader reader) {
        this.reader = reader;
    }

    /**
     * Attempts to log in a user with the given username and password.
     * If the username is "admin" and the password matches the hardcoded admin password,
     * the user is logged in as an admin.
     * Otherwise, the method checks the file for the username and password.
     *
     * @param user     the User object to update with login information.
     * @param username the username to log in with.
     * @param password the password to log in with.
     * @return true if login is successful, false otherwise.
     */
    @Override
    public boolean login(User user, String username, String password) {
        Map<String, String> users = reader.read(FILE_PATH);
        if ("admin".equals(username)) {
            if ("i<3c++".equals(password)) {
                user.setAdmin(true);
                user.setPassword(password);
                user.setUsername(username);
                return true;
            } else {
                System.out.println("Wrong password");
                return false;
            }
        }
        if (users.containsKey(username)) {
            String passwordFromFile = users.get(username);
            if (password.equals(passwordFromFile)) {
                user.setPassword(password);
                user.setUsername(username);
            } else {
                System.out.println("Wrong password");
                return false;
            }
        } else {
            System.out.println("User not found");
            return false;
        }
        return true;

    }

    /**
     * Logs out the user by clearing the username, password, and admin status.
     *
     * @param user the User object to log out.
     */
    @Override
    public void logout(User user) {
        user.setPassword(null);
        user.setUsername(null);
        user.setAdmin(false);
    }
}
