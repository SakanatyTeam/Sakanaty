package org.example;

import role.Owner;

import java.util.ArrayList;
import java.util.List;

public class Housing {
    private List<Floor> floors = new ArrayList<Floor>();
    private int id = 1;
    private String name;
    private String location;
    private String image;
    String[] services;
    private int price;
    Owner owner;
    private String type;
    public Housing(String name,String location, String image, int price, String[] services, String type) {
        this.name=name;
        this.id=id++;
        this.location = location;
        this.image = image;
        this.price = price;
        this.services=services;
        this.type=type;
    }
    public void addFloors(Floor floor){
        this.floors.add(floor);
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public int getId() {
        return id;
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

    public Owner getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }
}
