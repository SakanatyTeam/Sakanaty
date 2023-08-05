package org.example;

import role.Tenant;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private static int aid=1;
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


    public void addTenant(Tenant tenant){
        this.tenants.add(tenant);
    }
    public static int autoIncrementFloorId(){
        return aid++;
    }
}
