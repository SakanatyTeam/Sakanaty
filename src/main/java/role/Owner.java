package role;

import StaticDB.HousingList;
import org.example.Housing;
import org.example.LoginInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Owner extends User {

    private static final Logger LOGGER = Logger.getLogger(LoginInfo.class.getName());
    private String ownerID;
    private String phone;
    private int numHousings;

    private List<Housing> housingList = new ArrayList<Housing>();
    public Owner(String username, String password, String type, String ownerID , String phone, int numHousings) {
        super(username, password, type, ownerID);
//        this.ownerID = ownerID;
        this.phone = phone;
        this.numHousings = numHousings;
    }

}
