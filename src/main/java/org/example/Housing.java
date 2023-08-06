package org.example;


import java.util.ArrayList;
import java.util.List;

public class Housing {
    private List<Floor> floors = new ArrayList<>();
    private String name;
    private String location;
    private String image;
    String[] services;
    private int price;
    private String type;

    public String getType() {
        return type;
    }

    private int ownerID;
    Apartment apartment;

    public Housing(String name, String location, String image,int price, String[] services, int ownerID,String type) {
        this.name = name;
        this.location = location;
        this.image = image;
        this.services = services;
        this.price = price;
        this.type=type;
        this.ownerID = ownerID;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }

    public String[] getServices() {
        return services;
    }

    public int getPrice() {
        return price;
    }

    public int getOwnerID() { return ownerID; }
    public void setImage(String image) {
        this.image = image;
    }

    public void addFloors(Floor floor11) {
        floors.add(floor11);
    }

}
