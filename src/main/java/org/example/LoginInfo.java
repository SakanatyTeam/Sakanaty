package org.example;

import StaticDB.HousingList;
import StaticDB.UsersList;
import role.Housing;
import role.User;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LoginInfo {
    private static final Logger LOGGER = Logger.getLogger(LoginInfo.class.getName());
    public boolean adminIsLogged;
    public boolean ownerIsLogged;
    public boolean tenantIsLogged;

//    public boolean isLogged;
//    public LoginInfo() {
//        this.isLogged = false;
//    }

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
        return adminIsLogged && ownerIsLogged && tenantIsLogged;
    }
    public void login(){
//        isLogged = true;
        adminIsLogged=true;
        ownerIsLogged=true;
        tenantIsLogged=true;
    }
    public void logout(){
//        isLogged = false;
        adminIsLogged=false;
        ownerIsLogged=false;
        tenantIsLogged=false;
    }

    public void showHousing(){
        // display all information about available housing found
        LOGGER.info("----------- Choose the housing you want ------------");
        int i = 1;
        for(Housing housing: HousingList.getHousing()){
            LOGGER.info( i + "- Location: " + housing.getLocation() + " , " + "Price: " + housing.getPrice());
            i++;
        }
        LOGGER.info("0- Go bake.");
        LOGGER.info("-----------------------------------------------------");
    }

    public Housing findHousingByNumRow(String numRow) {
        List<Housing> housingByNumRow = new ArrayList<Housing>();
        int row = Integer.parseInt(numRow);

        return housingByNumRow.get(row-1);
    }
    public void showDetails(Housing housing) {
        if(housing==null)
        {
            LOGGER.info("This product is not exist");
        }
        else {
            LOGGER.info(" location: " + housing.getLocation() + "Price: " + housing.getPrice());
            LOGGER.info("0- Go bake.");
        }
    }


}
