package StaticDB;

import role.Housing;
import role.User;

import java.util.ArrayList;
import java.util.List;

public class HousingList {
    static List<Housing> housing =new ArrayList<Housing>();
    private HousingList() {throw new IllegalStateException("Utility class");}
    static{
        housing.add(new Housing("jit",800));
        housing.add(new Housing("jit1",500));
        housing.add(new Housing("jit2",600));
        housing.add(new Housing("jit3",1000));

    }
    public static List<Housing> getHousing() {return housing;}
}
