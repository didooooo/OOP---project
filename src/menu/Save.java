package menu;

import filesOperation.SaveFile;
import user.User;
/**
 * Saves the current state.
 *
 */
public class Save implements MenuCommand{
    private SaveFile saveFile;

    public Save(SaveFile saveFile) {
        this.saveFile = saveFile;
    }

    @Override
    public void execute(String[] data, User... user) {
        saveFile.saveFile();
    }
}
