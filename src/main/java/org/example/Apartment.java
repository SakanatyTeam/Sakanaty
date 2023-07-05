package org.example;

import role.Tenant;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private int apartmentId;
    private int maxTenantsNumber;
    private int currTenants;
    Tenant tenant;
    List<Tenant> tenants = new ArrayList<Tenant>();

    public Apartment(int apartmentId, int maxTenantsNumber, int currTenants, Tenant tenant, List<Tenant> tenants) {
        this.apartmentId = apartmentId;
        this.maxTenantsNumber = maxTenantsNumber;
        this.currTenants = currTenants;
        this.tenant = tenant;
        this.tenants = tenants;
    }
}
