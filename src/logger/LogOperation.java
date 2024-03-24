package logger;

import user.User;

public interface LogOperation {
    void login(User user, String username, String password);
    void logout(User user);
}
