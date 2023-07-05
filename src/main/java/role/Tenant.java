package role;

import StaticDB.HousingList;
import org.example.Housing;
import org.example.LoginInfo;

import java.util.logging.Logger;

public class Tenant extends User{
    private String Major;
    private int age;
    private int tenantId;
    private static final Logger LOGGER = Logger.getLogger(LoginInfo.class.getName());
    public Tenant(String username, String password,int tenantId,String type, String major, int age) {
        super(username, password, type);

        this.tenantId=tenantId;
    }

    public int viewHousings() {
        int i=1;
        for(Housing housing:HousingList.getHousing()){
            LOGGER.info(i+ "- Name: "+housing.getName()+"\nLocation: "+ housing.getLocation()+
                    "\nPrice: "+housing.getPrice()+"\nType: "+housing.getType());
            i++;
        }
        return 1;
    }

    public int viewDetails(int id) {

        return 1;

    }

    public void wrongID() {
    }
}
