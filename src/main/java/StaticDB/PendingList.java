package StaticDB;

import org.example.Housing;

import java.util.ArrayList;
import java.util.List;

public class PendingList {

    static List<Housing> housings =new ArrayList<Housing>();
    private PendingList() {throw new IllegalStateException("Utility class");}
    static {

    }

    public static List<Housing> getHousing() {return housings;}

    public static void addHousing(Housing housing) {
        housings.add(housing);
    }
}
