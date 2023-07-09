package StaticDB;

import role.Owner;
import role.Tenant;

import java.util.ArrayList;
import java.util.List;


public class OwnersList {
    public static List<Owner> owners=new ArrayList<Owner>();
    static{
        owners.add(new Owner("Bdair","Pass","Owner","100","0599407101",3));
    }

}

