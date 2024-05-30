package menu;

import logger.LogOperation;
import user.User;

import java.io.Console;
import java.util.Scanner;
/**
 * Logs in a user with the provided username and password.
 *
 */
public class Login implements MenuCommand{
    private LogOperation logOperation;

    public Login(LogOperation logOperation) {
        this.logOperation = logOperation;
    }

    @Override
    public void execute(String[] data, User... user) {
        if (user[1].getUsername()!=null) {
            throw  new RuntimeException("Already have a user");
        }
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        //String password = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] input = console.readPassword();
        for (char c : input) {
            if (c == '\n' || c == '\r') {
                sb.toString();
                break;
            }
            System.out.print("*");
            sb.append(c);
        }
        System.out.println();
        String password = sb.toString();
        logOperation.login(user[1], username, password);
    }
}
