

package role;
import staticdb.HousingList;
import staticdb.TenantsList;
import org.example.Apartment;
import org.example.Floor;
import org.example.Housing;
import java.util.*;
import java.util.logging.Logger;

public class Tenant extends User{

    public static final String COLOR_BLUE = "\u001b[35m";
    public static final String COLOR_GREEN = "\u001b[36m";
    public static final String COLOR_WHITE = "\u001b[37m";
    public static final String COLOR_PURPLE = "\n\u001b[35m";
    public static final String COLOR_FULL_GREEN = "\u001b[32m";

    public Tenant() {
        setType("Tenant");
        setApartmentID(-1);
    }
    private static Scanner scan=new Scanner(System.in);
    private String major;
    private int age;
    private int tenantId;
    private int apartmentID;
    private static final Logger LOGGER = Logger.getLogger(Tenant.class.getName());

    private static final String LINE = "\u001b[35m--------------------------------------------\u001b[0m";

    private static final String FILL = "--------------------------------------------";

    public Tenant(String username, String password, int tenantId, String type, String major, int age) {
        super(username,password,type,tenantId);
        this.major=major;
        this.age = age;
        this.apartmentID = -1;
        this.tenantId=tenantId;
    }

    public int getApartmentID() {
        return apartmentID;
    }

    public void setApartmentID(int apartmentID) {
        this.apartmentID = apartmentID;
    }

    public int viewHousings() {
        int i = 1;
        for(Housing housing:HousingList.getHousing()){
            String s = LINE + "\n" + i+ "- Name: "+housing.getName()+"\nLocation: "+ housing.getLocation()+ "\nPrice: "+housing.getPrice()+"\nType: "+housing.getType();
            LOGGER.info(s);i++;
        }
        return i;
    }

    public String getMajor() {
        return major;
    }

    public int getAge() {
        return age;
    }

    public int viewDetails(int id) {
        id--;
        Housing housing = HousingList.getHousing().get(id);
        String s;
        s="\n\u001b[33m"+ FILL +"\nName: "+ housing.getName()+"\nFloors: "+housing.getFloors().size() +"\n"+ FILL + COLOR_GREEN;
        LOGGER.info(s);
        int z = 0;
        for(Floor floor:housing.getFloors()){

            s= FILL + "\nFloor" + z + ", id: "+floor.getFloorId()+"\nMaximum apartments: "+floor.getMaxApartments();
            s=COLOR_GREEN + s +"\n"+ FILL + COLOR_BLUE;
            LOGGER.info(s);
            for (Apartment apartment: floor.getApartments()){
                s="Apartment ID:" + apartment.getApartmentId()+"\nMax Tenants: " +apartment.getMaxTenantsNumber()+"\nBathrooms: " + apartment.getBathrooms()+"\nBedrooms = "+apartment.getBedrooms();
                s=s + COLOR_BLUE;
                LOGGER.info(s);
                if (housing.getType().equals("Student"))
                {
                    s="\u001b[33m\nTenants: " + apartment.getCurrTenants() + "\n" + FILL + COLOR_WHITE;
                    LOGGER.info(s);
                    if(apartment.getTenants().isEmpty()) {
                        s="\u001b[31mThis apartment is empty.";
                        s=s + COLOR_WHITE;
                        LOGGER.info(s);
                        LOGGER.info(FILL);
                    }
                    else {
                        for (Tenant tenant : apartment.getTenants()) {
                            s="\nName: " + tenant.getUsername() + "\nMajor: " + tenant.getMajor() + "\nAge: " + tenant.getAge();
                            s=s + "\u001b[33m";
                            LOGGER.info(s);
                            s=FILL + COLOR_WHITE;
                            LOGGER.info(s);
                        }
                    }
                }
                if(apartment.apartmentIsFull()) {
                    s = "Not available - Apartment is full!";
                    s="\u001b[31m" + s + COLOR_PURPLE + FILL;
                    LOGGER.info(s);
                }
                else {
                    s="Available - you can rent here!";
                    s=COLOR_FULL_GREEN + s + COLOR_PURPLE + FILL;
                    LOGGER.info(s);
                }
            }

            s= COLOR_BLUE + "\nPreview: " + housing.getImage();
            s=s + COLOR_GREEN;
            LOGGER.info(s);
            z++;
        }
        return 1;
    }

    public int bookHouse(int id,int floorID, int apartmentID1,Tenant tenant) {
        String s;
        if(tenant.getApartmentID()!=-1) {
            s="You cant rent because you already rented in apartment " + tenant.getApartmentID();
            LOGGER.info(s);
            return 0;
        }
        else {
            Housing housing = HousingList.getHousing().get(id);
            if (housing.getFloors().get(floorID).getApartments().get(apartmentID1).apartmentIsFull()) {
                s="You cant book here because this apartment is full!";
                LOGGER.info(s);
                return 1;
            }
            else {
                tenant.setApartmentID(housing.getFloors().get(floorID).getApartments().get(apartmentID1).getApartmentId());
                housing.getFloors().get(floorID).getApartments().get(apartmentID1).addTenant(tenant);
                housing.getFloors().get(floorID).getApartments().get(apartmentID1).setCurrTenants(housing.getFloors().get(floorID).getApartments().get(apartmentID1).getCurrTenants() + 1);
                if (housing.getFloors().get(floorID).getApartments().get(apartmentID1).getMaxTenantsNumber() == housing.getFloors().get(floorID).getApartments().get(apartmentID1).getCurrTenants())
                    housing.getFloors().get(floorID).getApartments().get(apartmentID1).setApartmentIsFull(true);

                s="\n\u001b[32mBooking done.\u001b[0m";
                LOGGER.info(s);
                return 2;
            }
        }
    }

    public int viewFurnitures(Tenant tenant) {
        String s;
        for (Map.Entry<Tenant,ArrayList<Furniture>> entry : Furniture.getFurnitureList().entrySet()) {
            if(entry.getKey()!=tenant) {
                s="\n\u001b[36mOwner " + entry.getKey().getUsername() + ":\n";
                String str = "";
                for (Furniture furniture : entry.getValue()) {
                    str = str + furniture.getName() + "\t|\tPrice: " + furniture.getPrice() + "\t|\t\n";
                }
                str = s + str + "\u001b[0m";
                LOGGER.info(str);
                LOGGER.info(LINE);
            }
        }
        return 1;
    }

    public int buyFurniture(Tenant tenant, String name, String f) {
        String s;
        Tenant o = null;
        Furniture fr = null;
        for(Tenant t: TenantsList.getTenants()){
            if(t.getUsername().equals(name))
            {
                o=t;
            }
        }
        if(o==null){
            s="Invalid Name!";
            LOGGER.info(s);
            return 0;
        }
        for(Furniture furniture : Furniture.getFurnitureList().get(o)) {
            if (furniture.getName().equals(f)) {
                fr = furniture;
            }
        }
        if(fr==null){
            s="Invalid Furniture!";
            LOGGER.info(s);
            return 1;

        }
        if(tenant!=o) {
            Furniture.getFurnitureList().get(tenant).add(fr);
            Furniture.getFurnitureList().get(o).remove(fr);
            return 2;
        } else {
            s= "You cant buy from yourself!";
            LOGGER.info(s);
            return 3;
        }
    }
}


