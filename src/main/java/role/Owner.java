package role;

import org.example.Housing;

import java.util.ArrayList;
import java.util.List;

public class Owner extends User {
    private List<Housing> housingList = new ArrayList<Housing>();
    private Housing housing;
    public Owner(String username, String password, String type) {
        super(username, password, type);
    }



}
