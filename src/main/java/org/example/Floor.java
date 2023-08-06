package org.example;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private static int fid=1;

    public static void setFid() {
        fid=1;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    private List<Apartment> apartments = new ArrayList<>();
    private int floorId;

    public int getFloorId() {return floorId;}

    public int getMaxApartments() {
        return maxApartments;
    }

    private int maxApartments;

    public Floor(int floorId, int maxApartments) {
        this.floorId = floorId;
        this.maxApartments = maxApartments;
    }
    public void addApartment(Apartment apartment){
        apartments.add(apartment);
    }
    public static int autoIncrementTenantId(){
        return fid++;
    }
}
