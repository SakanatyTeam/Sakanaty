package role;

import StaticDB.HousingList;
import StaticDB.OwnersList;
import org.example.Housing;
import org.example.LoginInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Owner extends User {

    private static final Logger LOGGER = Logger.getLogger(LoginInfo.class.getName());
    private int ownerID;
    private String phone;
    private int numHousings;

    private List<Housing> housingList = new ArrayList<Housing>();
    public Owner(String username, String password, String type, int ownerID , String phone, int numHousings) {
        super(username, password, type);
        this.ownerID = ownerID;
        this.phone = phone;
        this.numHousings = numHousings;
    }

//    public static int autoIncrementOwnerId(){
//        int id = 101;
//        for (Owner owner: OwnersList.owners){
//            if (owner.ownerID > id) id = owner.ownerID+1;
//        }
//        return id;
//    }

}
