package logger;

import filesOperation.Reader;
import user.User;

import java.util.Map;

public class Logger implements LogOperation {
    private final Reader reader;
    private final String FILE_PATH = "Users.txt";
    public Logger(Reader reader) {
        this.reader = reader;
    }

    @Override
    public boolean login(User user, String username, String password) {
        Map<String, String> users = reader.read(FILE_PATH);
        if(users.containsKey(username)) {
            String passwordFromFile = users.get(username);
            if(password.equals(passwordFromFile)) {
                user.setPassword(password);
                user.setUsername(username);
            }else{
                System.out.println("Wrong password");
                return false;
            }
        }else{
            if("admin".equals(username)){
                if("i<3c++".equals(password)){
                    user.setAdmin(true);
                    user.setPassword(password);
                    user.setUsername(username);
                }else {
                    System.out.println("Wrong password");
                    return false;
                }
            }else {
                System.out.println("User not found");
                return false;
            }
        }
        return true;

    }

    @Override
    public void logout(User user) {
        user.setPassword(null);
        user.setUsername(null);
        user.setAdmin(false);
    }
}
