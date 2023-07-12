package StaticDB;

import org.example.Apartment;
import org.example.Floor;
import org.example.Housing;
import role.Tenant;

import java.util.ArrayList;
import java.util.List;

public class HousingList {
    static List<Housing> housings = new ArrayList<>();
    private HousingList() {throw new IllegalStateException("Utility class");}
    static{
        String[] services1= {"Cleaning","Eleveator"};
        String[] services2= {"Cleaning",};
        // public Housing( String location, String image, int price, String[] services, int floors)
        //public Tenant(String username, String password,int tenantId,String type, String major, String age)
        Apartment apartment111=new Apartment(111,3);
        apartment111.addTenant(new Tenant("Yazan","Pass",1,"Tenant","CE",15));
        apartment111.addTenant(new Tenant("Baraa","Pass",2,"Tenant","Civil Engineer",17));
        apartment111.addTenant(new Tenant("Ahmad","Pass",3,"Tenant","CAP",16));
        apartment111.setApartmentIsFull(true);
        apartment111.setCurrTenants(3);
        Apartment apartment112=new Apartment(112,2);
        apartment112.setApartmentIsFull(false);
        apartment111.setCurrTenants(0);
        Apartment apartment121=new Apartment(121,2);
        apartment121.addTenant(new Tenant("Aydi","Pass",1,"Tenant","Medicine",10));
        apartment121.setCurrTenants(1);

        Apartment apartment122=new Apartment(122,3);
        apartment122.addTenant(new Tenant("Ali","Pass",1,"Tenant","Media",10));
        apartment122.setCurrTenants(1);
        Apartment apartment123=new Apartment(123,1);
        apartment123.setCurrTenants(0);

        Apartment apartment131=new Apartment(131,1);
        apartment131.setCurrTenants(0);
        //////////
        Apartment apartment211=new Apartment(211,2);
        apartment211.addTenant(new Tenant("Mostafa","Pass",1,"Tenant","Medicine",10));
        apartment211.setCurrTenants(1);
        Apartment apartment212=new Apartment(212,1);
        apartment212.setCurrTenants(0);
        Apartment apartment221=new Apartment(221,1);
        apartment221.setCurrTenants(0);
        ////////
        //First housing Floors
        Floor floor11 = new Floor(1,2);
        floor11.addApartment(apartment111);
        floor11.addApartment(apartment112);

        Floor floor12 = new Floor(2,3);
        floor12.addApartment(apartment121);
        floor12.addApartment(apartment122);
        floor12.addApartment(apartment123);

        Floor floor13 = new Floor(3,1);
        floor13.addApartment(apartment131);
        ////////////////////
        //Second housing floors
        Floor floor21 = new Floor(1,2);
        floor21.addApartment(apartment211);
        floor21.addApartment(apartment212);
        Floor floor22 = new Floor(1,1);
        floor22.addApartment(apartment221);
        /////////////////////

        Housing house1=new Housing("Sakan1","jit","link",1200,services1,100,"Student");

        house1.addFloors(floor11);
        house1.addFloors(floor12);
        house1.addFloors(floor13);

        Housing house2=new Housing("Sakan2","Tulkarm","link2",200,services2,100,"General");
        house1.addFloors(floor21);
        house1.addFloors(floor22);

        housings.add(house1);
        housings.add(house2);
    }
    public static List<Housing> getHousing() {return housings;}

    public static void addHousing(Housing housing) {
        /* housing = new Housing(); */
        housings.add(housing);
    }
}
