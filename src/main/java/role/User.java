package role;

import StaticDB.HousingList;
import org.example.Housing;
import org.example.LoginInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class User {

    private static final Logger LOGGER = Logger.getLogger(LoginInfo.class.getName());
    private String username;
    private String password;
    private String type;

    private String id;

    public User(String username, String password, String type, String id) {
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

    public String getId() {return id;}

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {this.id = id;}



    public static List<Housing> getHousingList(String id) {

        List<Housing> housinglist = new ArrayList();
//        int id = Integer.parseInt(int1);
        for(Housing housing : HousingList.getHousing())
        {
//            System.out.println( housing.getOwnerID());
            if(housing.getOwnerID().equals(id))
                housinglist.add(housing);
        }
        return housinglist;
    }

    public static void viewMyHousings(List<Housing> housingList) {

        int i = 1;
        for(Housing housing : housingList)
        {
            LOGGER.info(i + "- " + housing.getName() + " , " + housing.getLocation() + " , " + housing.getPrice() + ".");
            i++;
        }
    }
}
