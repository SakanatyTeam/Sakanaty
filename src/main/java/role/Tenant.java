package role;

import StaticDB.HousingList;
import org.example.Housing;
import org.example.LoginInfo;

import java.util.logging.Logger;

public class Tenant extends User{
    private String type;
    private static final Logger LOGGER = Logger.getLogger(LoginInfo.class.getName());
    public Tenant(String username, String password, String type) {
        super(username, password, type);
    }

    public static int viewHousings() {

        return 0;
    }

//    public static int viewHousings() {
//        for(Housing housing: HousingList.getHousings()){
//            String[] services=housing.getServices();
//            LOGGER.info(housing.getLocation()+housing.getPrice()+housing.getImage()+housing.getServices().toString());
//        }
//        return 1;
//    }
}
