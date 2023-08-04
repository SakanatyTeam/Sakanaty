package role;

import org.example.LoginInfo;
import staticdb.HousingList;
import org.example.Apartment;
import org.example.Floor;
import org.example.Housing;

import java.util.Arrays;
import java.util.logging.Logger;

public class Admin  extends  User{
    private static final Logger LOGGER = Logger.getLogger(Admin.class.getName());
    public Admin() {
        setType("Admin");
        setUsername("YIS");
        setPassword("123");
    }
    public int viewRequests() {
        int i=1;
        String s;
        for(Housing housing: HousingList.getPendingHousings()){
            s= i++ + "- Name: "+housing.getName()+"\nLocation: "+housing.getLocation() +"\nOwnerID: "+housing.getOwnerID()+"\nServices: "+ Arrays.toString(housing.getServices());
            LOGGER.info(s);
            s= "This housing has "+housing.getFloors().size() +" floors: ";
            LOGGER.info(s);
            for (Floor floor:housing.getFloors()){
                s="Floor ID: " + floor.getFloorId()+"\tMax Apartments: "+floor.getMaxApartments();
                LOGGER.info(s);
            }
            s="***************";
            LOGGER.info(s);
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
        String s;
        for(Housing housing:HousingList.getHousing()){
            for (Floor floor:housing.getFloors())
            {
                for (Apartment apartment:floor.getApartments())
                {
                    for(Tenant tenant:apartment.getTenants()){
                        s= "Tenant Name: " + tenant.getUsername()+"\tHouse: " + housing.getName() +"\tFloor ID: "+floor.getFloorId()+"\tApartment: "+apartment.getApartmentId();
                        LOGGER.info(s);
                    }
                }
            }
        }
        return 1;
    }
}
