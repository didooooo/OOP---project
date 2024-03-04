import java.util.Map;

public class Register implements RegisterOperation{
    @Override
    public void add(User user) {
        Writer writer = new TextFileWriter();
        writer.write("Users",user);
    }

    @Override
    public void remove(User user) {
        Reader reader = new TextFileReader();
        Map<String, String> users = reader.read("Users");
        users.remove(user.getUsername());
        Writer writer = new TextFileWriter();
        writer.write("Users",users);
    }
}
