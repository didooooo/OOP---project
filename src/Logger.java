public class Logger implements LogOperation{
    @Override
    public void login(User user, String username, String password) {
        user.setUsername(username);
        user.setPassword(password);
    }

    @Override
    public void logout(User user) {
        user.setPassword(null);
        user.setUsername(null);
        user.setAdmin(false);
    }
}
