package org.example;

import role.Owner;

import java.util.ArrayList;
import java.util.List;

public class Housing {
    private List<Apartment> apartmennts = new ArrayList<Apartment>();
    private int id = 0;
    private String name;
    private String location;
    private String image;
    String[] services;
    private int price;
    private int floors;

    private String ownerID;


    Owner owner;
    Apartment apartment;



    public Housing(String name, String location, String image, int price, String[] services, int floors) {
        this.name=name;
        this.id=id++;
        this.location = location;
        this.image = image;
        this.price = price;
        this.services=services;
        this.floors=floors;
    }

    public Housing(String name, String location, String image,int price, String[] services, int floors, String ownerID) {
        this.name = name;
        this.location = location;
        this.image = image;
        this.services = services;
        this.price = price;
        this.floors = floors;
        this.ownerID = ownerID;
    }

    public List<Apartment> getApartmennts() {
        return apartmennts;
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

    public int getFloors() {
        return floors;
    }

    public String getOwnerID() { return ownerID; }

    public Owner getOwner() {
        return owner;
    }

    public Apartment getApartment() {
        return apartment;
    }
}
