package filesOperation;

import user.User;

import java.util.Map;

public interface Writer {
    void write(String path, User user);
    void write(String path, Map<String,String> users);
}
