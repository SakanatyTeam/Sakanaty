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

}
