package menu;

import filesOperation.CloseFIle;
import user.User;

public class Close implements MenuCommand{
    private CloseFIle closeFIle;

    public Close(CloseFIle closeFIle) {
        this.closeFIle = closeFIle;
    }

    @Override
    public void execute(String[] data, User... user) {
        closeFIle.close();
    }
}
