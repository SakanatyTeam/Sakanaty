package role;

import StaticDB.HousingList;
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


    public Owner(String username, String password, String type,int ownerID ,String phone,int numHousings) {
        super(username, password, type);
        this.ownerID = ownerID;
        this.phone = phone;
        this.numHousings = numHousings;
    }



    public static List<Housing> getHousingList(Integer int1) {

        List<Housing> housinglist = new ArrayList();
        for(Housing housing : HousingList.getHousing())
        {
            housing.getOwnerID();
            if(housing.getOwnerID() == int1){
                housinglist.add(housing);System.out.println("aasasaas000");}
        }
        return housinglist;
    }

    public static void viewMyHousings(List<Housing> housingList) {

        int i = 1;
        for(Housing housing : housingList)
        {System.out.println("aasasaas2");
            LOGGER.info(i + "- " + housing.getName() + " , " + housing.getLocation() + " , " + housing.getPrice() + ".");
            i++;
        }
    }
}
