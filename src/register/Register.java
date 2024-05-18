package register;

import filesOperation.Reader;
import filesOperation.TextFileWriter;
import filesOperation.Writer;
import user.User;

import java.io.File;
import java.util.Map;

public class Register implements RegisterOperation {
    private final Writer writer;
    private final Reader reader;
    private final String FILE_PATH = "Users.txt";
    private User user;
    private User loggedInUser;

    public Register(Writer writer, Reader reader, User user, User loggedInUser) {
        this.writer = writer;
        this.reader = reader;
        this.user = user;
        this.loggedInUser = loggedInUser;
    }

    @Override
    public boolean add(User user) {
        if(!loggedInUser.isAdmin()){
            throw new RuntimeException("You are not admin");
        }
        Map<String, String> users = reader.read(FILE_PATH);
        if (users.containsKey(user.getUsername())) {
            System.out.println("This user already exists!");
            return false;
        }
        writer.write(FILE_PATH,user);
        return true;
    }

    @Override
    public boolean remove(User user) {
        if(!loggedInUser.isAdmin()){
            throw new RuntimeException("You are not admin");
        }
        Map<String, String> users = reader.read(FILE_PATH);
        if (!users.containsKey(user.getUsername())) {
            System.out.println("There is no such user");
            return false;
        }
        users.remove(user.getUsername());
        Writer writer = new TextFileWriter();
        writer.write(FILE_PATH,users);
        return true;
    }

}
