package org.example;

import role.Owner;
import role.Tenant;
import role.User;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static Scanner scan=new Scanner(System.in);
    public static LoginInfo loginInfo = new LoginInfo();

    public static String userID;

    public static String selectHousing;

    public static void main(String[] args) {
        int tenantID=1;
        while(true){
            LOGGER.info("Enter username:");
            String username=scan.nextLine().trim().strip();
            if(username.equalsIgnoreCase("exit"))
                break;
            LOGGER.info("Enter Password:");
            String password = scan.nextLine();
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
                while (true)
                {
                    LOGGER.info("--------------- Dashboard ---------------");
                    LOGGER.info("1- View My Housing.");
                    LOGGER.info("2- Add Housing.");
                    LOGGER.info("3- sign out.");
                    String open=scan.nextLine();

                    if (open.equals("1")){
                        while (true) {
                            List<Housing> housingList1;
                            housingList1 = Owner.getHousingList(userID);
                            Owner.viewMyHousings(housingList1);
                            selectHousing = scan.nextLine();

                            if (selectHousing.equals("0")) break;
                            else if( Integer.parseInt(selectHousing) >= Owner.numHousing) continue;
                            else Owner.viewDetails(Owner.getHousing(Owner.getName(selectHousing)));





                                while (true) {
                                String details = scan.nextLine();
                                if (details.equals("1")) {

                                } else if (details.equals("2")) break;
                                else continue;
                            }
                        }
                    }
                    else if(open.equals("2")){

                    }
                    else if (open.equals("3")) break;
                    else continue;
                }










            }
            else if (loginInfo.tenantIsLogged){
                LOGGER.info("Enter your age: ");
                int age= scan.nextInt();
                LOGGER.info("Enter your Major: ");
//                Tenant tenant = new Tenant(username,password,tenantID++,"Tenant", scan.nextLine(),age);
                while (true)
                {
                    LOGGER.info("--------------- Dashboard ---------------");
                    LOGGER.info("1- View available housings");
                    LOGGER.info("2- Sign out");
                    if (scan.nextInt()==1) {
//                        tenant.viewHousings();
                        LOGGER.info("Select house number to view its information:");
//                        tenant.viewDetails(scan.nextInt());
                    }
                    else continue;

                }
            }
            else continue;
        }
    }
}