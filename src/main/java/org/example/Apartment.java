package org.example;

import role.Tenant;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private int apartmentId;
    private int maxTenantsNumber;
    private int currTenants;
    private boolean apartmentIsFull;

    public void setApartmentIsFull(boolean apartmentIsFull) {
        this.apartmentIsFull = apartmentIsFull;
    }

    public boolean isApartmentIsFull() {
        return apartmentIsFull;
    }

    public void setCurrTenants(int currTenants) {
        this.currTenants = currTenants;
    }

    List<Tenant> tenants = new ArrayList<Tenant>();

    public Apartment(int apartmentId, int maxTenantsNumber) {
        this.apartmentId = apartmentId;
        this.maxTenantsNumber = maxTenantsNumber;
        this.currTenants = currTenants;

    }

    public List<Tenant> getTenants() {
        return tenants;
    }

    public void addTenant(Tenant tenant){
        this.tenants.add(tenant);
    }
}
