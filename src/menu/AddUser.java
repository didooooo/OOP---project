package menu;

import register.RegisterOperation;
import user.User;

import java.io.Console;
import java.util.Scanner;
/**
 * Adds a new user if the current user is an admin.
 *
 */
public class AddUser implements MenuCommand{
    private RegisterOperation registerOperation;

    public AddUser(RegisterOperation registerOperation) {
        this.registerOperation = registerOperation;
    }

    @Override
    public void execute(String[] data, User... user) {
        if (user[1].getUsername()!=null) {
            Console console = System.console();
            if (console == null) {
                System.out.println("Couldn't get Console instance");
                System.exit(0);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter username: ");
            String username = scanner.nextLine();
            System.out.println("Enter password: ");
            // String password = scanner.nextLine();
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
            user[1].setUsername(username);
            user[1].setPassword(password);
            registerOperation.add(user[1]);
            return;
        }
        throw  new RuntimeException("Need admin to add an user");
    }
}
