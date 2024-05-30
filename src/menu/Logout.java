package menu;

import library.Library;
import logger.LogOperation;
import user.User;
/**
 * Logs out the current user.
 *
 */
public class Logout implements MenuCommand{
    private LogOperation logOperation;

    public Logout(LogOperation logOperation) {
        this.logOperation = logOperation;
    }

    @Override
    public void execute(String[] data, User... user) {
        if (user[1].getUsername()!=null) {
            logOperation.logout(user[1]);
            return;
        }
        throw new RuntimeException("Need to log in first");
    }
}
