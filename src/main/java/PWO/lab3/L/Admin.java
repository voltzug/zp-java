package PWO.lab3.L;

public class Admin extends User {
    private double age;
    private boolean loggedIn = false;
    private double[] permissions;

    public Admin(String userName, String login, String pwd) {
        super(userName, "Admin" + login, pwd);
    }

    public void setPermissions(double[] perms) {
        System.out.println("Set permissions");
        permissions = perms;
    }

    public double getPermission(int index) {
        return permissions[index];
    }
}
