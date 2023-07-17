package org.example;

import role.Owner;

import java.util.ArrayList;
import java.util.List;

public class Housing {
    private static List<Floor> floors = new ArrayList<Floor>();
    private int id = 0;
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
    Owner owner;
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

    public static List<Floor> getFloors() {
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

    public Owner getOwner() {
        return owner;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void addFloors(Floor floor11) {
        floors.add(floor11);
    }

}
