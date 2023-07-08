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
        users.add(new User("YIS","123","Admin", "1"));
        users.add(new User("Bdair","Pass","Owner", "100"));
        users.add(new User("Baraa","Pass","Tenant", "1000"));
        users.add(new User("Yazan","123","Tenant", "1001"));
    }
    public static List<User> getAdmins() {
        return users;
    }

}
