package StaticDB;

import org.example.Apartment;
import org.example.Floor;
import org.example.Housing;

import java.util.ArrayList;
import java.util.List;

public class HousingList {
    static List<Housing> housing =new ArrayList<Housing>();
    private HousingList() {throw new IllegalStateException("Utility class");}
    static{
        List<Apartment> aparts = new ArrayList<Apartment>();
        List<Floor> floors = new ArrayList<Floor>();
        String[] services1= {"Cleaning","Eleveator"};
        String[] services2= {"Cleaning",};
        // public Housing( String location, String image, int price, String[] services, int floors)
        Apartment apartment111=new Apartment(111,3);
        Apartment apartment112=new Apartment(112,2);

        Apartment apartment121=new Apartment(121,2);
        Apartment apartment122=new Apartment(122,3);
        Apartment apartment123=new Apartment(123,1);

        Apartment apartment131=new Apartment(131,1);
        //////////
        Apartment apartment211=new Apartment(211,2);
        Apartment apartment212=new Apartment(212,1);

        Apartment apartment221=new Apartment(221,1);

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
        Floor floor22 = new Floor(1,2);
        floor22.addApartment(apartment221);
        /////////////////////

        Housing house1=new Housing("Sakan1","jit","link",1200,services1,"student");

        house1.addFloors(floor11);
        house1.addFloors(floor12);
        house1.addFloors(floor13);

        Housing house2=new Housing("Sakan2","Tulkarm","link2",200,services2,"general");
        house1.addFloors(floor21);
        house1.addFloors(floor22);

        housing.add(house1);
        housing.add(house2);
    }
    public static List<Housing> getHousing() {return housing;}
}
