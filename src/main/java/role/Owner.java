package role;

import java.util.ArrayList;
import java.util.List;

public class Owner extends User {
    private int ownerID;
    private List<Housing> housingList = new ArrayList<Housing>();
    public Owner(int ownerID,String username, String password, String type) {
        super(username, password, type);
        this.ownerID=ownerID;
    }


}
