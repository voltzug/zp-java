package PWO.lab3.L;

public class SuUser extends User {
    private double age;
    private double[] permissions;

    public SuUser(String userName, String login, String pwd) {
        super(userName, login, pwd);
    }

    public void setPermissions(double[] perms) {
        permissions = perms;
    }

    @Override
    public double[] getPermissions() {
        return permissions;
    }
}
