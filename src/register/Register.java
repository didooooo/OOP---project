package register;

import filesOperation.Reader;
import filesOperation.TextFileWriter;
import filesOperation.Writer;
import user.User;

import java.io.File;
import java.util.Map;

/**
 * The Register class implements the RegisterOperation interface, providing methods
 * to add and remove users from the system.
 */
public class Register implements RegisterOperation {
    private final Writer writer;
    private final Reader reader;
    private final String FILE_PATH = "Users.txt";


    public Register(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    /**
     * Adds a user to the system.
     *
     * @param user the User instance to be added.
     * @return true if the user is successfully added, false otherwise.
     */
    @Override
    public boolean add(User user) {
        Map<String, String> users = reader.read(FILE_PATH);
        if (users.containsKey(user.getUsername())) {
            System.out.println("This user already exists!");
            return false;
        }
        writer.write(FILE_PATH, user);
        return true;
    }

    /**
     * Removes a user from the system.
     *
     * @param user the User instance to be removed.
     * @return true if the user is successfully removed, false otherwise.
     */

    @Override
    public boolean remove(User user) {
        Map<String, String> users = reader.read(FILE_PATH);
        if (!users.containsKey(user.getUsername())) {
            System.out.println("There is no such user");
            return false;
        }
        users.remove(user.getUsername());
        Writer writer = new TextFileWriter();
        writer.write(FILE_PATH, users);
        return true;
    }

}
