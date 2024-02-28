public class Users implements LogOperation {
    private String username;
    private String password;
    private boolean isAdmin;

    public Users(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public void login(String username,String password) {
        this.username=username;
        this.password=password;
        System.out.printf("Welcome, %s!%n",username);
    }

    @Override
    public void logout() {

    }
}
