package role;

import StaticDB.HousingList;
import org.example.Housing;
import org.example.LoginInfo;
import org.example.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class User {

    private static final Logger LOGGER = Logger.getLogger(LoginInfo.class.getName());
    private String username;
    private String password;
    private String type;

    private int id;

    public static int numHousing = 0;

    public User(String username, String password, String type, int id) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {return type;}

    public int getId() {return id;}

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(int id) {this.id = id;}


}
