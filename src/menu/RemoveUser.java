package menu;

import register.RegisterOperation;
import user.User;

import java.util.Scanner;
/**
 * Removes a user if the current user is an admin.
 *
 */
public class RemoveUser implements MenuCommand{
    private RegisterOperation registerOperation;

    public RemoveUser(RegisterOperation registerOperation) {
        this.registerOperation = registerOperation;
    }

    @Override
    public void execute(String[] data, User... user) {
        if (user[1].getUsername()!=null) {
            System.out.println("Enter username: ");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.nextLine();
            user[1].setUsername(username);
            registerOperation.remove(user[1]);
            return;
        }
        throw new RuntimeException("Need admin to remove a user");
    }
}
