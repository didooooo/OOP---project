package register;

import user.User;

public interface RegisterOperation {
    boolean add(User user);
    boolean remove(User user);
}
