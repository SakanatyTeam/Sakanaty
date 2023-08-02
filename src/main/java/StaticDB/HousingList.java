package StaticDB;

import org.example.Apartment;
import org.example.Floor;
import org.example.Housing;
import role.Tenant;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HousingList {
    static List<Housing> housing = new ArrayList<Housing>();
    public static List<Housing> pendingHousings = new ArrayList<Housing>();

    static {
        String[] services1 = {"Cleaning", "Eleveator"};
        String[] services2 = {"Cleaning"};
        Apartment apartment111 = new Apartment(111, 3);
        apartment111.addTenant(TenantsList.tenants.get(1));
        apartment111.addTenant(TenantsList.tenants.get(2));
        apartment111.addTenant(TenantsList.tenants.get(3));
        apartment111.setBathrooms(1);
        apartment111.setBedrooms(2);
        apartment111.setApartmentIsFull(true);
        apartment111.setCurrTenants(3);
        Apartment apartment112 = new Apartment(112, 2);
        apartment112.setBedrooms(1);
        apartment112.setBathrooms(2);
        apartment112.setApartmentIsFull(false);
        apartment112.setCurrTenants(0);


        Apartment apartment121 = new Apartment(121, 2);
        apartment121.setBedrooms(3);
        apartment121.setBathrooms(1);
        apartment121.addTenant(TenantsList.tenants.get(4));
        apartment121.setCurrTenants(1);


        Apartment apartment122 = new Apartment(122, 3);
        apartment122.setBathrooms(3);
        apartment122.setBedrooms(4);
        apartment122.addTenant(TenantsList.tenants.get(5));
        apartment122.setCurrTenants(1);


        Apartment apartment123 = new Apartment(123, 1);
        apartment123.setBedrooms(1);
        apartment123.setBathrooms(1);
        apartment123.setCurrTenants(0);


        Apartment apartment131 = new Apartment(131, 1);
        apartment131.setBathrooms(3);
        apartment131.setBedrooms(2);
        apartment131.setCurrTenants(0);

        Apartment apartment211 = new Apartment(211, 2);
        apartment211.addTenant(TenantsList.tenants.get(6));
        apartment211.setCurrTenants(1);
        apartment211.setBedrooms(2);
        apartment211.setBathrooms(3);

        Apartment apartment212 = new Apartment(212, 1);
        apartment212.setCurrTenants(0);
        apartment212.setBathrooms(1);
        apartment212.setBedrooms(1);


        Apartment apartment221 = new Apartment(221, 1);
        apartment221.setCurrTenants(0);
        apartment221.setBedrooms(2);
        apartment221.setBathrooms(3);


        Floor floor11 = new Floor(1, 2);
        floor11.addApartment(apartment111);
        floor11.addApartment(apartment112);

        Floor floor12 = new Floor(2, 3);
        floor12.addApartment(apartment121);
        floor12.addApartment(apartment122);
        floor12.addApartment(apartment123);

        Floor floor13 = new Floor(3, 1);
        floor13.addApartment(apartment131);

        Floor floor21 = new Floor(4, 2);
        floor21.addApartment(apartment211);
        floor21.addApartment(apartment212);
        Floor floor22 = new Floor(5, 1);
        floor22.addApartment(apartment221);


        Housing house1 = new Housing("Sakan1", "jit", "link", 1200, services1, 100, "Student");

        house1.addFloors(floor11);
        house1.addFloors(floor12);
        house1.addFloors(floor13);
        house1.setImage("");
        Housing house2 = new Housing("Sakan2", "Tulkarm", "link2", 200, services2, 100, "General");
        house1.setImage("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/8105260c-cfc1-463e-b35b-5de2d500fac9/df9wgvg-801e4bc3-486b-47e4-8cbe-6399082ce140.png/v1/fill/w_809,h_560/luffy___nika___gear_5_by_caiquenadal_df9wgvg-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9NTYwIiwicGF0aCI6IlwvZlwvODEwNTI2MGMtY2ZjMS00NjNlLWIzNWItNWRlMmQ1MDBmYWM5XC9kZjl3Z3ZnLTgwMWU0YmMzLTQ4NmItNDdlNC04Y2JlLTYzOTkwODJjZTE0MC5wbmciLCJ3aWR0aCI6Ijw9ODA5In1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.EsZtlByyzE5ZPoRUDcRc4SyhvXJNx27eQ3lEDR5RPmk");
        house2.addFloors(floor21);
        house2.addFloors(floor22);

        housing.add(house1);
        housing.add(house2);
        pendingHousings.add(house1);
        pendingHousings.add(house2);

    }

    public static List<Housing> getHousing() {
        return housing;
    }

    public static List<Housing> getPendingHousings() {
        return pendingHousings;
    }
        public static void addHousing (Housing h){
            /* housing = new Housing(); */
            housing.add(h);
        }
}

