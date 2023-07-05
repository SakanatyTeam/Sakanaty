package StaticDB;

import org.example.Apartment;
import org.example.Housing;

import java.util.ArrayList;
import java.util.List;

public class HousingList {
    static List<Housing> housing =new ArrayList<Housing>();
    private HousingList() {throw new IllegalStateException("Utility class");}
    static{
        List<Apartment> aparts = new ArrayList<Apartment>();
//        aparts.add(new Apartment())
        String[] services= {"Cleaning","Eleveator"};
        // public Housing( String location, String image, int price, String[] services, int floors)
        housing.add(new Housing("Sakan1","jit","link",1200,services,4));
        housing.add(new Housing("Sakan2","tulkarm","link",1200,services,4));
        housing.add(new Housing("Sakan3","nablus","link",1200,services,4));
        housing.add(new Housing("Sakan4","jenin","link",1200,services,4));
    }
    public static List<Housing> getHousing() {return housing;}
}
