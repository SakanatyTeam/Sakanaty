package org.example;

import StaticDB.HousingList;
import role.Owner;
import role.Tenant;
import role.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static StaticDB.TenantsList.tenants;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static Scanner scan = new Scanner(System.in);

    public static LoginInfo loginInfo = new LoginInfo();

    public static int userID;

    public static String selectHousing;

    public static Housing housing1;
    public static Floor floor1;
    public static Apartment apartment1;

    public static List <Floor> floorList1 = new ArrayList<Floor>();

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
                    LOGGER.info("1- View All Housing.");
                    LOGGER.info("2- Pending Housing.");
                    LOGGER.info("3- Add Housing.");
                    LOGGER.info("4- Sign Out.");
                    String open=scan.nextLine();

                    if (open.equals("2")){

                    }
                }
            }
            else if (loginInfo.ownerIsLogged) {
                while (true) {
                    LOGGER.info("--------------- Dashboard ---------------");
                    LOGGER.info("1- View My Housing.");
                    LOGGER.info("2- Add Housing.");
                    LOGGER.info("3- Sign Out.");
                    String open = scan.nextLine();

                    if (open.equals("1")) {
                        while (true) {
                            List<Housing> housingList1;
                            housingList1 = Owner.getHousingList(userID);
                            System.out.println(userID);
                            LOGGER.info("--------- Select Housing To Update Or Delete ---------");
                            Owner.viewMyHousings(housingList1);
                            LOGGER.info(Owner.numHousing + "- Go Back.");
                            LOGGER.info("------------------------------------------------------");
                            selectHousing = scan.nextLine();

                            if (Integer.parseInt(selectHousing) > Owner.numHousing) continue;
                            else if (Integer.parseInt(selectHousing) == Owner.numHousing) break;
                            else {

                                // update and delete ....
//                                while (true) {
//                                    String details = scan.nextLine();
//                                    if (details.equals("1")) {
//
//                                    } else if (details.equals("2")) break;
//                                    else continue;
//                                }
                            }
                        }
                    }
                    else if (open.equals("2")) {
                        String name;
                        String location;
                        String image;
                        int price;
                        String []service;
                        String type;
                        int ownerId = userID;
                        LOGGER.info("Add Name: ");
                        name = scan.nextLine();
                        LOGGER.info("Add Location: ");
                        location = scan.nextLine();
                        LOGGER.info("Add image: ");
                        image = scan.nextLine();
                        LOGGER.info("Add Price: ");
                        price = Integer.parseInt(scan.nextLine());
                        LOGGER.info("Add Service: ");
                        service = scan.nextLine().split(",");
                        LOGGER.info("Add Type: ");
                        type = scan.nextLine();
                        housing1 = new Housing(name,location,image,price,service,ownerId,type);

                        LOGGER.info("Add Number of Floors: ");
                        int numFloor = Integer.parseInt(scan.nextLine());
                        String []temp = new String[numFloor];
                        String []xy = new String[2];
                        int []numApartments = new int[numFloor];
                        int []maxTenantNum = new int[numFloor];
                        for (int z=0; z< numFloor; z++){
                            LOGGER.info("Add Number of Apartments in floor" + z + " and Max Tenants Number (x,y): ");
                            temp[z] = scan.nextLine();
                            xy = temp[z].split(",");
                            numApartments[z] = Integer.parseInt(xy[0]);
                            maxTenantNum[z] = Integer.parseInt(xy[1]);
                            floor1 = new Floor(Floor.autoIncrementTenantId(),numApartments[z]);
                            for (int i=0; i<numApartments[z]; i++){
                                apartment1 = new Apartment(Apartment.autoIncrementFloorId(),maxTenantNum[z]);
                                floor1.addApartment(apartment1);
                            }
                            housing1.addFloors(floor1);
                        }
                        System.out.println(housing1);
                        HousingList.addHousing(housing1);
                        LOGGER.info("------------------------ DONE ------------------------");

                        for (Housing h: HousingList.getHousing()){
                            System.out.println(h);
                        }

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
                    LOGGER.info("2- Sign out");
                    if (scan.nextInt()==1) {
                        tenant.viewHousings();
                        LOGGER.info("Select house number to view its information:");
                        try{
                            tenant.viewDetails(scan.nextInt());
                            LOGGER.info("Select house number to book it!");
                            tenant.bookHouse(scan.nextInt());
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Wrong ID");
                        }


                    }
                    else continue;

                }
            }
            else continue;
        }
    }
}