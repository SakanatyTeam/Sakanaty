package org.example;
import staticdb.UsersList;
import role.User;

import java.util.logging.Logger;

public class LoginInfo {
    private static final Logger LOGGER = Logger.getLogger(LoginInfo.class.getName());
    private boolean adminIsLogged;
    private boolean ownerIsLogged;
    private boolean tenantIsLogged;
    public int checkAuth(String username, String password) {
       logout();
       int id=1;
        for (User user : UsersList.getAdmins()) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                if (user.getType().equals("Owner"))
                    ownerIsLogged = true;

                if (user.getType().equals("Admin"))
                    adminIsLogged = true;
                if (user.getType().equals("Tenant"))
                    tenantIsLogged = true;
                id = user.getId() ;
            }
        }
        return id;
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

    public boolean isAdminIsLogged() {
        return adminIsLogged;
    }

    public boolean isOwnerIsLogged() {
        return ownerIsLogged;
    }

    public boolean isTenantIsLogged() {
        return tenantIsLogged;
    }
}
