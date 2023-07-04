package org.example;

import StaticDB.UsersList;
import role.Admin;
import role.User;

import java.util.logging.Logger;

public class LoginInfo {
    private static final Logger LOGGER = Logger.getLogger(LoginInfo.class.getName());
    public boolean adminIsLogged;
    public boolean ownerIsLogged;
    public boolean tenantIsLogged;
    public boolean isLogged;

    public LoginInfo() {
        this.isLogged = false;
    }
    public void reset(){
        adminIsLogged=false; ownerIsLogged=false; tenantIsLogged=false;
    }

    public void checkAuth(String username, String password) {
        reset();
        for(User user: UsersList.getAdmins())
        {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword()))
            {
                if (user.getType().equals("Owner"))
                    ownerIsLogged=true;
                if (user.getType().equals("Admin"))
                    adminIsLogged=true;
                if (user.getType().equals("Tenant"))
                    tenantIsLogged=true;
            }
        }

    }

    public void showError() {
        LOGGER.info("Incorrect Username/Password");
    }

    public boolean isLoggedIn() {
        return isLogged;
    }
    public void login(){
        isLogged = true;
    }
    public void logout(){
        isLogged = false;
    }

}
