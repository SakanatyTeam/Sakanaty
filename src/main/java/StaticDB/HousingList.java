package StaticDB;

import org.example.Housing;
import role.User;

import java.util.ArrayList;
import java.util.List;

public class HousingList {
    static List<Housing> housings=new ArrayList<Housing>();
    static {
        String services[]={"Cleaning", "Elevator", "Food"};;
        String services2[]={"Cleaning", "Elevator", "Food"};;
        String services3[]={"Cleaning", "Elevator", "Food"};;
        housings.add(new Housing("Tulkarm", "",1200,services));
        housings.add(new Housing("test", "",1200,services2));
        housings.add(new Housing("test", "",1200,services3));
    }

    public static List<Housing> getHousings() {
        return housings;
    }
}
