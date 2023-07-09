package org.example;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    public List<Apartment> getApartments() {
        return apartments;
    }

    private List<Apartment> apartments = new ArrayList<Apartment>();
    private int floorId;
    private int maxApartments;

    public Floor(int floorId, int maxApartments) {
        this.floorId = floorId;
        this.maxApartments = maxApartments;
    }
    public void addApartment(Apartment apartment){
        apartments.add(apartment);
    }
}
