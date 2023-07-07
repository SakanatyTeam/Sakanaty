package StaticDB;

import role.Tenant;
import role.User;

import java.util.ArrayList;
import java.util.List;

public class TenantsList {
    public static List<Tenant> tenants=new ArrayList<Tenant>();
    static{
       //Tenant(String username, String password,int tenantId,String type, String major, int age)
        tenants.add(new Tenant("Baraa","Pass",1,"Tenant","CE",16));
        tenants.add(new Tenant("Yazan","Pass",2,"Tenant","Medicine",17));

    }

}
