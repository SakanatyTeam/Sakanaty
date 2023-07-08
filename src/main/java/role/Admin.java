package role;

public class Admin  extends  User{

    private String username;
    private String password;
    public Admin(String username,String password) {
        super("test","test","test", "1");

        this.username=username;
        this.password=password;
    }


}
