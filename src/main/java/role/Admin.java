package role;

public class Admin  extends  User{

    private String username;
    private String password;
    public Admin(String username,String password) {
        super("test","test","test");

        this.username=username;
        this.password=password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

}
