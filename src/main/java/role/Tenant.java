package role;

import StaticDB.HousingList;
import org.example.Housing;
import org.example.LoginInfo;

import java.util.logging.Logger;

public class Tenant extends User{
    private String Major;
    private String age;
    private int tenantId;
    private static final Logger LOGGER = Logger.getLogger(LoginInfo.class.getName());
    public Tenant(String username, String password,int tenantId,String type, String major, String age) {
        super(username, password, type);
        this.tenantId=tenantId;
    }

//    public static int viewHousings() {
//        for(Housing housing: HousingList.getHousings()){
//            String[] services=housing.getServices();
//            LOGGER.info(housing.getLocation()+housing.getPrice()+housing.getImage()+housing.getServices().toString());
//        }
//        return 1;
//    }
}
