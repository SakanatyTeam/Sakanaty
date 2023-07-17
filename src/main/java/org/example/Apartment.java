package org.example;

import role.Tenant;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private int currTenants;
    private boolean apartmentIsFull;
    private int apartmentId;
    private int maxTenantsNumber;

    public int getCurrTenants() {
        return currTenants;
    }

    public int getMaxTenantsNumber() {
        return maxTenantsNumber;
    }

    int bathrooms;
    int bedrooms;

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public int getBedrooms() {
        return bedrooms;
    }




    public void setApartmentIsFull(boolean apartmentIsFull) {
        this.apartmentIsFull = apartmentIsFull;
    }

    public boolean apartmentIsFull() {
        return this.apartmentIsFull;
    }

    public void setCurrTenants(int currTenants) {
        this.currTenants = currTenants;
    }

    List<Tenant> tenants = new ArrayList<Tenant>();

    public Apartment(int apartmentId, int maxTenantsNumber) {
        this.apartmentId = apartmentId;
        this.maxTenantsNumber = maxTenantsNumber;
        this.currTenants = 0;
        this.apartmentIsFull=false;

    }

    public int getApartmentId() {
        return apartmentId;
    }

    public List<Tenant> getTenants() {
        return tenants;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void addTenant(Tenant tenant){
        this.tenants.add(tenant);
    }

    public static List<Apartment> createApartment(String string, String string2) {
        List<Apartment> apartmentList  = new ArrayList();
        String []ids = string.split(",");
        String []maxApartment = string2.split(",");
        for (int i=0; i< ids.length; i++){
            int id = Integer.parseInt(ids[i]);
            int max = Integer.parseInt(maxApartment[i]);
            Apartment apartment = new Apartment(id,max);
            apartmentList.add(apartment);
        }
        return apartmentList;
    }

    public static int autoIncrementFloorId(){
        int id = 301;
        for (Apartment apartment: Floor.getApartments()){
            if (apartment.getApartmentId() > id) id = apartment.getApartmentId();
        }
        return id;
    }
}
