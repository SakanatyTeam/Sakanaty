package role;
import staticdb.HousingList;
import staticdb.TenantsList;
import org.example.Apartment;
import org.example.Floor;
import org.example.Housing;
import java.util.*;
import java.util.logging.Logger;

public class Tenant extends User{

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

    public int viewHousings() {int i=1;
        for(Housing housing:HousingList.getHousing()){
            String s = i+ "- Name: "+housing.getName()+"\nLocation: "+ housing.getLocation()+ "\nPrice: "+housing.getPrice()+"\nType: "+housing.getType();
            LOGGER.info(s);i++;
        }
        return 1;
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
        s="Name: "+ housing.getName()+"\nFloors: "+housing.getFloors().size();
        LOGGER.info(s);
        for(Floor floor:housing.getFloors()){
            s="****************\nFloor id: "+floor.getFloorId()+"\nMaximum apartments: "+floor.getMaxApartments();
            LOGGER.info(s);
            for (Apartment apartment: floor.getApartments()){
                s="________\nApartment ID:" + apartment.getApartmentId()+"\nMax Tenants: " +apartment.getMaxTenantsNumber()+"\nBathrooms: " + apartment.getBathrooms()+"\nBedrooms = "+apartment.getBedrooms();
                LOGGER.info(s);
                if (housing.getType().equals("Student"))
                {
                    s="Tenants: " + apartment.getCurrTenants();
                    LOGGER.info(s);
                    if(apartment.getTenants().isEmpty()) {
                        s="This apartment is empty.";
                        LOGGER.info(s);
                    }
                    else {
                        for (Tenant tenant : apartment.getTenants()) {
                            s="Name: " + tenant.getUsername() + "\nMajor: " + tenant.getMajor() + "\nAge: " + tenant.getAge() + "\n-------";
                            LOGGER.info(s);
                        }
                    }
                }
                if(apartment.apartmentIsFull()) {
                    s = "Not available - Apartment is full!";
                    LOGGER.info(s);
                }
                else {
                    s="Available - you can rent here!";
                    LOGGER.info(s);
                }
            }
            s="***************************";
            LOGGER.info(s);
            s="Preview: " + housing.getImage();
            LOGGER.info(s);
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
                return 2;
            }
        }
    }

    public int viewFurnitures(Tenant tenant) {
        String s;
        for (Map.Entry<Tenant,ArrayList<Furniture>> entry : Furniture.getFurnitureList().entrySet()) {
            if(entry.getKey()!=tenant) {
                s="Owner " + entry.getKey().getUsername() + ":";
                LOGGER.info(s);
                for (Furniture furniture : entry.getValue()) {
                    s=furniture.getName() + "\t|\tPrice: " + furniture.getPrice() + "\t|\t";
                    LOGGER.info(s);
                }
                s="*************";
                LOGGER.info(s);
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
