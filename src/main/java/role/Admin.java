package role;

import StaticDB.HousingList;
import org.example.Apartment;
import org.example.Floor;
import org.example.Housing;

import java.util.Arrays;

public class Admin  extends  User{
    public Admin() {
        setType("Admin");
        setUsername("YIS");
        setPassword("123");
    }
    public int viewRequests() {
        int i=1;
        for(Housing housing: HousingList.getPendingHousings()){
            System.out.println(i++ + "- Name: "+housing.getName()+"\nLocation: "+housing.getLocation() +"\nOwnerID: "+housing.getOwnerID()+"\nServices: "+ Arrays.toString(housing.getServices()));
            System.out.println("This housing has "+housing.getFloors().size() +" floors: ");
            for (Floor floor:housing.getFloors()){
                System.out.println("Floor ID: " + floor.getFloorId()+"\tMax Apartments: "+floor.getMaxApartments());
            }
            System.out.println("***************");
        }
        return i;
    }

    public int takeAction(int nextInt,int id) {
        if (nextInt != 1 && nextInt!=2)
            return 0;
        else if (nextInt==1)
        {
            HousingList.getHousing().add(HousingList.getPendingHousings().get(--id)) ;
            HousingList.getPendingHousings().remove(id);
            return 1;
        }
        else {
            HousingList.getPendingHousings().remove(--id);
            return 2;
        }
    }

    public int showReservations() {
        for(Housing housing:HousingList.getHousing()){
            for (Floor floor:housing.getFloors())
            {
                for (Apartment apartment:floor.getApartments())
                {
                    for(Tenant tenant:apartment.getTenants()){
                        System.out.println("Tenant Name: " + tenant.getUsername()+"\tHouse: " + housing.getName() +"\tFloor ID: "+floor.getFloorId()+"\tApartment: "+apartment.getApartmentId());
                    }
                }
            }
        }
        return 1;
    }
}
