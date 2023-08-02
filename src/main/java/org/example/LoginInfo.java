package org.example;
import StaticDB.UsersList;
import role.User;

import java.util.logging.Logger;

public class LoginInfo {
    private static final Logger LOGGER = Logger.getLogger(LoginInfo.class.getName());
    public boolean adminIsLogged;
    public boolean ownerIsLogged;
    public boolean tenantIsLogged;
    public void reset(){
        adminIsLogged=false; ownerIsLogged=false; tenantIsLogged=false;
    }
    public int checkAuth(String username, String password) {
        reset();
        int i = 0;
        for (User user : UsersList.getAdmins()) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                if (user.getType().equals("Owner"))
                    ownerIsLogged = true;

                if (user.getType().equals("Admin"))
                    adminIsLogged = true;
                if (user.getType().equals("Tenant"))
                    tenantIsLogged = true;
                i++;
                Main.userID = user.getId();
            }
        }
        return 1;
    }
    public void showError() {
        LOGGER.info("Incorrect Username/Password");
    }

    public boolean isLoggedIn() {
        return adminIsLogged && ownerIsLogged && tenantIsLogged;
    }
    public void login(){
        adminIsLogged=true;
        ownerIsLogged=true;
        tenantIsLogged=true;
    }
    public void logout(){
        adminIsLogged=false;
        ownerIsLogged=false;
        tenantIsLogged=false;
    }


}
