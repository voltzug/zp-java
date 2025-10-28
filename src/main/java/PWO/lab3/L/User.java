package PWO.lab3.L;

public class User {
    protected String userName;
    protected String login;
    private String pwdHash;
    protected UserService service;

    public User(String userName, String login, String pwd) {
        this.userName = userName;
        this.login = login;
        this.pwdHash = SHA256.hash(pwd);
    }

    public void logIn(String password) {
        if (pwdHash.equals(SHA256.hash(password))) {
            service.logIn(userName, pwdHash);
        } else {
            throw new IllegalArgumentException("Invalid password");
        }
    }

    public void logOut() {
        service.logOut(userName);
    }

    public double[] getPermissions() {
        return null;
    }
}
