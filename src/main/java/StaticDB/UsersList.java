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
        users.add(new User("YIS","123","Admin"));
        users.add(new User("Bdair","Pass","Owner"));
        users.add(new User("Baraa","Pass","Tenant"));
        users.add(new User("Yazan","Pass","Tenant"));
    }
    public static List<User> getAdmins() {
        return users;
    }

}
