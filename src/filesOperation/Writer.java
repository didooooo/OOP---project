package filesOperation;

import library.Library;
import user.User;

import java.util.Map;

public interface Writer {
    void write(String path, User user);
    void write(String path, Map<String,String> users);
    void write(String path, Library library);
}
