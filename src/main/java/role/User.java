package role;

import staticdb.HousingList;
import org.example.Housing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class User {

    private static final Logger LOGGER = Logger.getLogger(User.class.getName());
    private String username;
    private String password;
    private String type;

    private int id;

    private static int numHousing = 0;

    public static int getNumHousing() {return numHousing;}
    public User(String username, String password, String type, int id) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.id=id;
    }

    public User() {
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


    public static List<Housing> getHousingList(int id) {

        List<Housing> housinglist = new ArrayList<Housing>();
        for(Housing housing : HousingList.getHousing())
        {
            if(housing.getOwnerID() == id)
                housinglist.add(housing);
        }
        return housinglist;
    }

    public static int viewMyHousings(List<Housing> housingList) {

        int i = 1;
        for(Housing housing : housingList)
        {
            String s = i+ "- " + housing.getName() + " , " + housing.getLocation() + " , "+ housing.getImage() +
                    " , " + housing.getPrice() + " , " + Arrays.toString(housing.getServices()) + ".";
            LOGGER.info(s);
            i++;
        }
        numHousing = i;
        return numHousing;
    }

    }
