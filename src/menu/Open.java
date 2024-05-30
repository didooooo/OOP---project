package menu;

import filesOperation.OpenFile;
import user.User;
/**
 * Opens a file from a specified file path.
 *
 */
public class Open implements MenuCommand{
    private OpenFile openFile;

    public Open(OpenFile openFile) {
        this.openFile = openFile;
    }

    @Override
    public void execute(String[] data, User... user) {
        openFile.read(data[1]);
    }
}
