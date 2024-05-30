package menu;

import user.User;

public interface MenuCommand {
    void execute(String[] data, User...user);
}
