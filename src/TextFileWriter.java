import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class TextFileWriter implements Writer {
    @Override
    public void write(String path, User user) {
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(user.getUsername() + " " + user.getPassword() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(String path, Map<String, String> users) {
        try (FileWriter fileWriter = new FileWriter(path, false)) {
            for (Map.Entry<String, String> kvp : users.entrySet()) {
                fileWriter.write(kvp.getKey() + " " + kvp.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
