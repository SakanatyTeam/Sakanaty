package role;

import staticdb.HousingList;
import org.example.Housing;
import org.example.LoginInfo;

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

        List<Housing> housinglist = new ArrayList();
        for(Housing housing : HousingList.getHousing())
        {
            if(housing.getOwnerID() == id)
                housinglist.add(housing);
        }
        return housinglist;
    }

    public static void viewMyHousings(List<Housing> housingList) {

        int i = 1;
        for(Housing housing : housingList)
        {
//            System.out.println( housing.getOwnerID() + "sssssssssss");
            LOGGER.info( i+ "- " + housing.getName() + " , " + housing.getLocation() + " , "+ housing.getImage() +
                    " , " + housing.getPrice() + " , " + Arrays.toString(housing.getServices()) + ".");
            i++;
        }
        numHousing = i;
    }
//
//
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
//                " , " + housing.getPrice() + " , " + Arrays.toString(housing.getServices()) + ".");
//        LOGGER.info("0- Go Back.");
//        LOGGER.info("1- Update.");
//        LOGGER.info("2- Delete.");
//        LOGGER.info("--------------------------------------------------");
//    }

    }
