package register;

import filesOperation.Reader;
import filesOperation.TextFileReader;
import filesOperation.TextFileWriter;
import filesOperation.Writer;
import user.User;
import java.util.Map;

public class Register implements RegisterOperation {
    @Override
    public boolean add(User user) {
        Writer writer = new TextFileWriter();
        Reader reader = new TextFileReader();
        Map<String, String> users = reader.read("Users");
        if(users.containsKey(user.getUsername())){
            System.out.println("This user already exists!");
            return false;
        }
        writer.write("Users",user);
        return true;
    }

    @Override
    public boolean remove(User user) {
        Reader reader = new TextFileReader();
        Map<String, String> users = reader.read("Users");
        if(!users.containsKey(user.getUsername())){
            System.out.println("There is no such user");
            return false;
        }
        users.remove(user.getUsername());
        Writer writer = new TextFileWriter();
        writer.write("Users",users);
        return true;
    }
}
