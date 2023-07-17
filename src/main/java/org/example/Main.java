package org.example;

import StaticDB.HousingList;
import StaticDB.TenantsList;
import role.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static StaticDB.TenantsList.tenants;

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
                Admin admin = new Admin();
                while (true){
                    LOGGER.info("--------------- Dashboard ---------------");
                    LOGGER.info("1- Show Pending Houses info");
                    LOGGER.info("2- Show Reservations");
                    LOGGER.info("3- sign out");
                    int in=scan.nextInt();
                    if (in==1){
                        int i=admin.viewRequests();
                        if(i>1) {
                            System.out.println("Enter a number from the menu above to accept or reject it");
                            int x = scan.nextInt();
                            if(x<i)
                            {
                                System.out.println("Choose Action:\n1-Accept\n2-Reject");
                                if(admin.takeAction(scan.nextInt(),x)==1)
                                    System.out.println("House accepted Successfully");
                                else   System.out.println("House Rejected Successfully");

                            }else{
                                System.out.println("Wrong house number");
                            }

                        }
                        else{
                            System.out.println("No current requests");
                        }
                    }
                    else if(in==2){
                        System.out.println("test");
                        admin.showReservations();
                    }
                    else break;
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

                Tenant tenant = new Tenant();
                for(Tenant tenant1 : tenants){
                    if(tenant1.getUsername().equals(username))
                        tenant= tenant1;
                }
                while (true)
                {
                    LOGGER.info("--------------- Dashboard ---------------");
                    LOGGER.info("1- View available housings");
                    LOGGER.info("2- View Furnitures");
                    LOGGER.info("3- Sign out");
                    int x = scan.nextInt();
                    scan.nextLine();
                    if (x==1) {
                        tenant.viewHousings();
                        LOGGER.info("Select house number to view its information:");
                        try{
                            tenant.viewDetails(scan.nextInt());
                            LOGGER.info("Select house number to book it!");
                            int hid=scan.nextInt();
                            Housing housing = HousingList.getHousing().get(--hid);
                            LOGGER.info("Choose floor: ");
                            int i = 1;
                            for (; i <= housing.getFloors().size(); i++) {
                                System.out.println(i);
                            }
                            int floorNum = scan.nextInt();
                            floorNum--;
                            i=1;
                            LOGGER.info("Choose Apartment: ");
                            for (; i <= housing.getFloors().get(floorNum).getApartments().size(); i++) {
                                System.out.println(i);
                            }
                            int apartNum = scan.nextInt();
                            apartNum--;
                            tenant.bookHouse(hid,floorNum,apartNum, tenant);
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Wrong ID");
                        }
                    }
                    else if(x==2){
                        tenant.viewFurnitures(tenant);
                        System.out.println("Enter Owner name and furniture type you want to buy or enter exit to quit:");
                        System.out.println("Owner name: ");
                        String name = scan.nextLine();
                        if (name.equals("exit"))
                            continue;
                        System.out.println("Enter Furniture name as in the list:");
                        String f = scan.nextLine();
                        tenant.buyFurniture(tenant,name,f);
                    }
                    else continue;
                }
            }
            else continue;
        }
    }
}