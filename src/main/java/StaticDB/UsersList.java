package StaticDB;

import role.User;

import java.util.ArrayList;
import java.util.List;

public class UsersList {
    static List<User> users=new ArrayList<User>();
    private UsersList() {
        throw new IllegalStateException("Utility class");
    }
    static{
        users.add(new User("YIS","123","Admin",0));
        users.add(new User("Bdair","123","Owner",100));
        users.add(new User("Yazan","123","Tenant",1));
        users.add(new User("Adel","Pass","Tenant",2));
        users.add(new User("Baraa","Pass","Tenant",3));
        users.add(new User("Ahmad","Pass","Tenant",4));
        users.add(new User("Aydi","Pass","Tenant",5));
        users.add(new User("Ali","Pass","Tenant",6));
        users.add(new User("Mostafa","Pass","Tenant",7));

    }
    public static List<User> getAdmins() {
        return users;
    }

}
