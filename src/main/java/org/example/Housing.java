package org.example;

public class Housing {
    private static int id;
    private String location;
    private String image;
    String[] services;
    private int price;

    public Housing(String location, String image, int price, String[] services) {
        this.location = location;
        this.image = image;
        this.price = price;
        this.services=services;
    }

    public static int getId() {
        return id;
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
}
