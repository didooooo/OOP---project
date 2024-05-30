package menu;

import filesOperation.SaveAsFile;
import user.User;
/**
 * Saves the current state to a specified file path.
 *
 */
public class SaveAs implements MenuCommand{
    private SaveAsFile saveAsFile;

    public SaveAs(SaveAsFile saveAsFile) {
        this.saveAsFile = saveAsFile;
    }

    @Override
    public void execute(String[] data, User... user) {
        saveAsFile.save(data[1]);
    }
}
