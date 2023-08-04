package staticdb;

import role.User;

import java.util.ArrayList;
import java.util.List;

public class UsersList {
    private static final String TENANT = "Tenant";
    public UsersList() {
    }

    static List<User> users=new ArrayList<User>();
    static{
        users.add(new User("YIS","123","Admin",0));
        users.add(new User("Bdair","123","Owner",100));
        users.add(new User("Yazan","123",TENANT,1));
        users.add(new User("Adel","Pass", TENANT,2));
        users.add(new User("Baraa","Pass", TENANT,3));
        users.add(new User("Ahmad","Pass", TENANT,4));
        users.add(new User("Aydi","Pass", TENANT,5));
        users.add(new User("Ali","Pass", TENANT,6));
        users.add(new User("Mostafa","Pass", TENANT,7));

    }
    public static List<User> getAdmins() {
        return users;
    }

}
