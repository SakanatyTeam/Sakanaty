package staticdb;

import role.Furniture;
import role.Tenant;

import java.util.ArrayList;
import java.util.List;

public class TenantsList {
    public static List<Tenant> tenants=new ArrayList<Tenant>();
    static{
        Tenant t0=new Tenant("Yazan","123",1,"Tenant","Medicine",17);
        Furniture.addFurniture(t0,new Furniture(1,"Table",15),new Furniture(2,"Shelf",10));
        tenants.add(t0);
        Tenant t1=  new Tenant("Adel","Pass",2,"Tenant","CE",15);
        t1.setApartmentID(111);
        Furniture.addFurniture(t1,new Furniture(1,"Sofa",150));
        Tenant t2=  new Tenant("Baraa","Pass",3,"Tenant","Civil Engineer",17);
        t2.setApartmentID(111);

        t1.setApartmentID(111);
        Furniture.addFurniture(t2,new Furniture(1,"Bed",100));
        Tenant t3=  new Tenant("Ahmad","Pass",4,"Tenant","CAP",16);
        t3.setApartmentID(111);

        Furniture.addFurniture(t3,new Furniture(1,"Picture",5));
        Tenant t4=  new Tenant("Aydi","Pass",5,"Tenant","Medicine",10);
        t4.setApartmentID(121);

        Tenant t5=  new Tenant("Ali","Pass",6,"Tenant","Media",10);
        t5.setApartmentID(122);
        Furniture.addFurniture(t5,new Furniture(1,"Chair Leg Aydi",0));
        Tenant t6=  new Tenant("Mostafa","Pass",7,"Tenant","Medicine",10);
        //t6.setApartmentID(221);
        Furniture.addFurniture(t6,new Furniture(1,"Desk",2000));
        tenants.add(t1);tenants.add(t2);tenants.add(t3);tenants.add(t4);tenants.add(t5);tenants.add(t6);

    }

}
