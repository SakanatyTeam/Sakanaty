package org.example;

import java.util.ArrayList;
import java.util.List;

public class Floor {



    public List<Apartment> getApartments() {
        return apartments;
    }

    private static List<Apartment> apartments = new ArrayList<Apartment>();
    private int floorId;

    public int getFloorId() {
        return floorId;
    }

    private int maxApartments;

    public Floor(int floorId, int maxApartments) {
        this.floorId = floorId;
        this.maxApartments = maxApartments;
    }
    public void addApartment(Apartment apartment){
        apartments.add(apartment);
    }


    public static List<Floor> createFloor(String string, String string2) {
        List<Floor> floorList  = new ArrayList();
        String []ids = string.split(",");
        String []maxApartment = string2.split(",");
        for (int i=0; i< ids.length; i++){
            int id = Integer.parseInt(ids[i]);
            int max = Integer.parseInt(maxApartment[i]);
            Floor floor = new Floor(id,max);
            floorList.add(floor);
        }
        return floorList;
    }

    public static void setApartment(List<Apartment> apartmentList) {
        for (Apartment a : apartmentList){
//            Floor.addApartment(a);
        }
    }
}
