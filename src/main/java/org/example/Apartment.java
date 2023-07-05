package org.example;

import role.Tenant;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private int apartmentId;
    private int maxTenantsNumber;
    private int currTenants;

    public void setCurrTenants(int currTenants) {
        this.currTenants = currTenants;
    }

    List<Tenant> tenants = new ArrayList<Tenant>();

    public Apartment(int apartmentId, int maxTenantsNumber) {
        this.apartmentId = apartmentId;
        this.maxTenantsNumber = maxTenantsNumber;
        this.currTenants = currTenants;

    }
    public void addTenant(Tenant tenant){
        this.tenants.add(tenant);
    }
}
