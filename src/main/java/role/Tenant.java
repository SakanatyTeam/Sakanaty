package role;
import staticdb.HousingList;
import staticdb.TenantsList;
import org.example.Apartment;
import org.example.Floor;
import org.example.Housing;
import org.example.LoginInfo;
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
    private static final Logger LOGGER = Logger.getLogger(LoginInfo.class.getName());

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
            LOGGER.info(i+ "- Name: "+housing.getName()+"\nLocation: "+ housing.getLocation()+ "\nPrice: "+housing.getPrice()+"\nType: "+housing.getType());i++;
        }
        return 1;
    }

    public String getMajor() {
        return major;
    }

    public int getAge() {
        return age;
    }

    public static int viewDetails(int id) {
//        System.out.println(HousingList.getHousing().get(1).getFloors().size());
        id--;
        Housing housing = HousingList.getHousing().get(id);
        System.out.println("Name: "+ housing.getName()+"\nFloors: "+housing.getFloors().size());
        for(Floor floor:housing.getFloors()){
            System.out.println("****************\nFloor id: "+floor.getFloorId()+"\nMaximum apartments: "+floor.getMaxApartments());
            for (Apartment apartment: floor.getApartments()){
                System.out.println("________\nApartment ID:" + apartment.getApartmentId()+"\nMax Tenants: " +apartment.getMaxTenantsNumber()+"\nBathrooms: " + apartment.getBathrooms()+"\nBedrooms = "+apartment.getBedrooms());
                if (housing.getType().equals("Student"));
                {
                    System.out.println("Tenants: " + apartment.getCurrTenants());
                    if(apartment.getTenants().size()==0)
                        System.out.println("This apartment is empty.");else
                    for (Tenant tenant : apartment.getTenants())
                    {
                        System.out.println("Name: "+tenant.getUsername()+"\nMajor: "+ tenant.getMajor() + "\nAge: "+ tenant.getAge()+"\n-------");
                    }
                }
                if(apartment.apartmentIsFull())
                    System.out.println("Not available - Apartment is full!");
                else System.out.println("Available - you can rent here!");
            }
            System.out.println("***************************");
            System.out.println("Preview: " + housing.getImage());
        }
        return 1;
    }

    public int bookHouse(int id,int floorID, int apartmentID1,Tenant tenant) {
        if(tenant.getApartmentID()!=-1) {
            System.out.println("You cant rent because you already rented in apartment " + tenant.getApartmentID());
            return 0;
        }
        else {
            Housing housing = HousingList.getHousing().get(id);
            if (housing.getFloors().get(floorID).getApartments().get(apartmentID1).apartmentIsFull()) {
                System.out.println("You cant book here because this apartment is full!");
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
        for (Map.Entry<Tenant,ArrayList<Furniture>> entry : Furniture.furnitureList.entrySet()) {
            if(entry.getKey()!=tenant) {
                System.out.println("Owner " + entry.getKey().getUsername() + ":");
                for (Furniture furniture : entry.getValue()) {
                    System.out.println(furniture.name + "\t|\tPrice: " + furniture.price + "\t|\t");
                }
                System.out.println("*************");
            }
        }
        return 1;
    }

    public int buyFurniture(Tenant tenant, String name, String f) {
        Tenant o = null;
        Furniture fr = null;
        for(Tenant t: TenantsList.tenants){
            if(t.getUsername().equals(name))
            {
                o=t;
            }
        }
        if(o==null){
            System.out.println("Invalid Name!");
            return 0;
        }
        for(Furniture furniture : Furniture.furnitureList.get(o)) {
            if (furniture.name.equals(f)) {
                fr = furniture;
            }
        }
        if(fr==null){
            System.out.println("Invalid Furniture!");
            return 1;

        }
        if(tenant!=o) {
            Furniture.furnitureList.get(tenant).add(fr);
            Furniture.furnitureList.get(o).remove(fr);
            return 2;
        } else {System.out.println("You cant buy from yourself!");return 3;}
    }
}
