package role;

import StaticDB.HousingList;
import org.example.Housing;
import org.example.LoginInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


public class Owner extends User {

    private static final Logger LOGGER = Logger.getLogger(LoginInfo.class.getName());
    private String ownerID;
    private String phone;
    private int numHousings;

    private List<Housing> housingList = new ArrayList<Housing>();


    public Owner(String username, String password, String type, int ownerID) {
        super(username, password, type, ownerID);
//        this.ownerID = ownerID;
    }

    public Owner(String username, String password, String type, int ownerID , String phone, int numHousings) {
        super(username, password, type, ownerID);
//        this.ownerID = ownerID;
        this.phone = phone;
        this.numHousings = numHousings;
    }



    public static List<Housing> getHousingList(int id) {

        List<Housing> housinglist = new ArrayList();
//        int id = Integer.parseInt(int1);
        for(Housing housing : HousingList.getHousing())
        {
//            System.out.println( housing.getOwnerID());
            if(housing.getOwnerID() == id)
                housinglist.add(housing);
        }
        return housinglist;
    }

    public static void viewMyHousings(List<Housing> housingList) {

        int i = 1;
        for(Housing housing : housingList)
        {
            LOGGER.info( i+ "- " + housing.getName() + " , " + housing.getLocation() + " , "+ housing.getImage() +
                    " , " + housing.getPrice() + " , " + Arrays.toString(housing.getServices()) + " , " + housing.getFloors() +  ".");
            i++;
        }
        numHousing = i;
    }


//    public static String getName(String selectHousing) {
//        int i = 1;
//        for(Housing housing : HousingList.getHousing()){
//            if (i == Integer.parseInt(selectHousing)){
//                return housing.getName();
//            }
//            i++;
//        }
//        return null;
//    }
//    public static Housing getHousing(String name) {
//        for(Housing housing : HousingList.getHousing()){
//            if (housing != null && housing.getName().equals(name)) {
//                return housing;
//            }
//        }
//        return null;
//    }
//    public static void viewDetails(Housing housing) {
//        LOGGER.info("--------- Select To View Housing Details ---------");
//        LOGGER.info("Housing Details: " + housing.getName() + " , " + housing.getLocation() + " , "+ housing.getImage() +
//                " , " + housing.getPrice() + " , " + Arrays.toString(housing.getServices()) + " , " + housing.getFloors() +  ".");
//        LOGGER.info("0- Go Back.");
//        LOGGER.info("1- Update.");
//        LOGGER.info("2- Delete.");
//        LOGGER.info("--------------------------------------------------");
//    }
}
