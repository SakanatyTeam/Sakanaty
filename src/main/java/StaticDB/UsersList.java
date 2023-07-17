package StaticDB;

import role.Tenant;
import role.User;

import java.util.ArrayList;
import java.util.List;

public class UsersList {
    static List<User> users=new ArrayList<User>();
    private UsersList() {
        throw new IllegalStateException("Utility class");
    }
    static{
        users.add(new User("YIS","123","Admin"));
        users.add(new User("Bdair","123","Owner"));
        users.add(new User("Yazan","123","Tenant"));
        users.add(new User("Adel","Pass","Tenant"));
        users.add(new User("Baraa","Pass","Tenant"));
        users.add(new User("Ahmad","Pass","Tenant"));
        users.add(new User("Aydi","Pass","Tenant"));
        users.add(new User("Ali","Pass","Tenant"));
        users.add(new User("Mostafa","Pass","Tenant"));

    }
    public static List<User> getAdmins() {
        return users;
    }

}
