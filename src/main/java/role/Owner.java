package role;

import org.example.Housing;

import java.util.ArrayList;
import java.util.List;

public class Owner extends User {
    private int ownerID;
    private String phone;

    private List<Housing> housingList = new ArrayList<Housing>();

    public Owner(int ownerID,String username, String password, String type,String phone) {
        super(ownerID,username, password, type);
        this.phone = phone;
    }



    public int viewHousing() {



        return 0;
    }
}
