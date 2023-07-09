package role;

import StaticDB.HousingList;
import org.example.Floor;
import org.example.Housing;
import org.example.LoginInfo;

import java.util.Scanner;
import java.util.logging.Logger;

public class Tenant extends User{
    public Tenant() {
    }
    private static Scanner scan=new Scanner(System.in);
    private String major;
    private int age;
    private int tenantId;
    private static final Logger LOGGER = Logger.getLogger(LoginInfo.class.getName());

    public Tenant(String username, String password, int tenantId, String type, String major, int age) {
        this.major=major;
        this.age = age;
        this.tenantId=tenantId;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
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
    public void wrongID() {
    }

    public String getMajor() {
        return major;
    }

    public int getAge() {
        return age;
    }

    public int getTenantId() {
        return tenantId;
    }

    public String getUsername() {
        return "test";

    }
    public static int viewDetails(int id) {
        id--;
        Housing housing = HousingList.getHousing().get(id);
        System.out.println(housing.getName());
        return 1;
    }

    public void bookHouse(int id) {
        id--;
        Housing housing = HousingList.getHousing().get(id);
        System.out.println("name:"+housing.getName());
        LOGGER.info("Choose floor: ");
        int i=1;
        for (; i<housing.getFloors().size();i++)
        {
            System.out.println(i);
        }
        int floorNum= scan.nextInt();
        i--;
        int j=1;
        LOGGER.info("Choose Apartment: ");
        for(;j<housing.getFloors().get(i).getApartments().size();j++)
        {
            System.out.println(j);
        }
        j--;
        System.out.println(housing.getFloors().get(i).getApartments().get(j).getTenants().get(0).getUsername());
    }
}
