package logger;

import filesOperation.Writer;
import user.User;

public class Logger implements LogOperation {
    @Override
    public void login(User user, String username, String password) {
        user.setUsername(username);
        user.setPassword(password);
        if("admin".equals(username)){
            if("i<3c++".equals(password)){
                user.setAdmin(true);
            }else {
                System.out.println("Wrong password");
            }
        }
    }

    @Override
    public void logout(User user) {
        user.setPassword(null);
        user.setUsername(null);
        user.setAdmin(false);
    }
}
