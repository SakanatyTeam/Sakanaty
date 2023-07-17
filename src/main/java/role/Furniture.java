package role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Furniture {
    public Furniture() {
    }

    public static Map<Tenant, ArrayList<Furniture>> furnitureList = new HashMap<Tenant, ArrayList<Furniture>>();;

    public static void addFurniture(Tenant tenant,Furniture...furniture){
        furnitureList.put(tenant,new ArrayList<>());
        for(Furniture furniture1:furniture){
            furnitureList.get(tenant).add(furniture1);
        }
    }

    private int id;
    private String name;
    private int price;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Furniture(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
