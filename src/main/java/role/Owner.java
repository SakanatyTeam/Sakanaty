package role;

import StaticDB.Housing;

import java.util.ArrayList;
import java.util.List;

public class Owner extends User {
    private List<Housing> housingList = new ArrayList<Housing>();
    private Housing housing;
    public Owner(String username, String password, String type) {
        super(username, password, type);
    }
    public void addHousing(int id, String location, String image, int price){
        this.housing = new Housing( location, image,price);

    }



}
