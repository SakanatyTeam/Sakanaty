package org.example;

import role.Tenant;
import role.User;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.logging.Logger;

import static StaticDB.TenantsList.tenants;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static Scanner scan=new Scanner(System.in);
    static LoginInfo loginInfo = new LoginInfo();
    public static void main(String[] args) {
        int tenantID=1;
        while(true){
            LOGGER.info("Enter username:");
            String username=scan.nextLine().trim().strip();
            if(username.equalsIgnoreCase("exit"))
                break;
            LOGGER.info("Enter Password:");
            String password = scan.nextLine();
            Tenant tenant = null;
            loginInfo.checkAuth(username,password);
            if(!loginInfo.adminIsLogged && !loginInfo.ownerIsLogged && !loginInfo.tenantIsLogged)
                loginInfo.showError();
            else if (loginInfo.adminIsLogged){
                while (true)
                {
                    LOGGER.info("--------------- Dashboard ---------------");
                    LOGGER.info("1- Show my Housing");
                    LOGGER.info("2- Add Housing");
                    LOGGER.info("3- sign out");
                    String open=scan.nextLine();

                }
            }
            else if (loginInfo.ownerIsLogged){
                LOGGER.info("Hello Owner");
            }
            else if (loginInfo.tenantIsLogged){

                for(Tenant tenant1 : tenants){
                    if(tenant1.getUsername().equals(username))
                        tenant= tenant1;
                }
                while (true)
                {
                    LOGGER.info("--------------- Dashboard ---------------");
                    LOGGER.info("1- View available housings");
                    LOGGER.info("2- Sign out");
                    if (scan.nextInt()==1) {
                        tenant.viewHousings();
                        //1-- hosuing
                        //2--- hosung

                        LOGGER.info("Select house number to view its information:");
                        tenant.viewDetails(scan.nextInt());

                    }
                    else continue;

                }
            }
            else continue;
        }
    }
}