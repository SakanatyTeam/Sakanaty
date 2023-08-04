package org.example;

import staticdb.HousingList;
import role.*;
import role.Tenant;
import role.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static staticdb.TenantsList.tenants;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static Scanner scan = new Scanner(System.in);

    private static LoginInfo loginInfo = new LoginInfo();

    private static int userID;


    private static String selectHousing;

    private static Housing housing1;
    private static Floor floor1;
    private static Apartment apartment1;

    public static void main(String[] args) {
        while (true) {
            LOGGER.info("Enter username:");
            String username = scan.nextLine().trim().strip();
            if (username.equalsIgnoreCase("exit"))
                break;
            LOGGER.info("Enter Password:");
            String password = scan.nextLine();
            loginInfo.checkAuth(username, password,userID);

            if (!loginInfo.isAdminIsLogged() && !loginInfo.isOwnerIsLogged() && !loginInfo.isTenantIsLogged())
                loginInfo.showError();
            else if (loginInfo.isAdminIsLogged()) {
                Admin admin = new Admin();
                while (true) {
                    LOGGER.info("--------------- Dashboard ---------------");
                    LOGGER.info("1- Show Pending Houses info");
                    LOGGER.info("2- Show Reservations");
                    LOGGER.info("3- sign out");
                    int in = scan.nextInt();
                    if (in == 1) {
                        int i = admin.viewRequests();
                        if (i > 1) {
                            System.out.println("Enter a number from the menu above to accept or reject it");
                            int x = scan.nextInt();
                            if (x < i) {
                                System.out.println("Choose Action:\n1-Accept\n2-Reject");
                                if (admin.takeAction(scan.nextInt(), x) == 1)
                                    System.out.println("House accepted Successfully");
                                else System.out.println("House Rejected Successfully");

                            } else {
                                System.out.println("Wrong house number");
                            }

                        } else {
                            System.out.println("No current requests");
                        }
                    } else if (in == 2) {
                        System.out.println("test");
                        admin.showReservations();
                    } else break;
                }
            } else if (loginInfo.isOwnerIsLogged()){
                while (true) {
                    LOGGER.info("--------------- Dashboard ---------------");
                    LOGGER.info("1- View My Housing.");
                    LOGGER.info("2- Add Housing.");
                    LOGGER.info("3- Sign Out.");
                    String open = scan.nextLine();

                    if (open.equals("1")) {
                        while (true) {
                            List<Housing> housingList1;
                            housingList1 = User.getHousingList(userID);
//                            System.out.println(userID);
                            LOGGER.info("--------- Select Housing To Update Or Delete ---------");
                            User.viewMyHousings(housingList1);
                            LOGGER.info(User.numHousing + "- Go Back.");
                            LOGGER.info("------------------------------------------------------");
                            selectHousing = scan.nextLine();

                            if (Integer.parseInt(selectHousing) > User.numHousing) continue;
                            else if (Integer.parseInt(selectHousing) == User.numHousing) break;
                        }
                    }
                            else if (open.equals("2")) {
                                String name;
                                String location;
                                String image;
                                int price;
                                String[] service;
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
                                housing1 = new Housing(name, location, image, price, service, ownerId, type);

                                LOGGER.info("Add Number of Floors: ");
                                int numFloor = Integer.parseInt(scan.nextLine());
                                String[] temp = new String[numFloor];
                                String[] xy = new String[2];
                                int[] numApartments = new int[numFloor];
                                int[] maxTenantNum = new int[numFloor];
                                for (int z = 0; z < numFloor; z++) {
                                    LOGGER.info("Add Number of Apartments in floor" + z + " and Max Tenants Number (x,y): ");
                                    temp[z] = scan.nextLine();
                                    xy = temp[z].split(",");
                                    numApartments[z] = Integer.parseInt(xy[0]);
                                    maxTenantNum[z] = Integer.parseInt(xy[1]);
                                    floor1 = new Floor(Floor.autoIncrementTenantId(), numApartments[z]);
                                    for (int i = 0; i < numApartments[z]; i++) {
                                        apartment1 = new Apartment(Apartment.autoIncrementFloorId(), maxTenantNum[z]);
                                        floor1.addApartment(apartment1);
                                    }
                                    housing1.addFloors(floor1);
                                }
                                Floor.setFid();

                                HousingList.pendingHousings.add(housing1);
                                LOGGER.info("------------------------ DONE ------------------------");
                            } else if (open.equals("3")) break;
                            else continue;
                        }
                    } else if (loginInfo.isTenantIsLogged()) {

                        Tenant tenant = new Tenant();
                        for (Tenant tenant1 : tenants) {
                            if (tenant1.getUsername().equals(username))
                                tenant = tenant1;
                        }
                        while (true) {
                            LOGGER.info("--------------- Dashboard ---------------");
                            LOGGER.info("1- View available housings");
                            LOGGER.info("2- View Furnitures");
                            LOGGER.info("3- Sign out");
                            int x = scan.nextInt();
                            scan.nextLine();
                            if (x == 1) {
                                tenant.viewHousings();
                                LOGGER.info("Select house number to view its information:");
                                try {
                                    tenant.viewDetails(scan.nextInt());

                                    LOGGER.info("Select house number to book it!");
                                    int hid = scan.nextInt();
                                    Housing housing = HousingList.getHousing().get(--hid);
                                    LOGGER.info("Choose floor: ");
                                    int i = 1;
                                    for (; i <= housing.getFloors().size(); i++) {
                                        System.out.println(i);
                                    }
                                    int floorNum = scan.nextInt();
                                    floorNum--;
                                    i = 1;
                                    LOGGER.info("Choose Apartment: ");
                                    for (; i <= housing.getFloors().get(floorNum).getApartments().size(); i++) {
                                        System.out.println(i);
                                    }
                                    int apartNum = scan.nextInt();
                                    apartNum--;
                                    tenant.bookHouse(hid, floorNum, apartNum, tenant);
                                } catch (IndexOutOfBoundsException e) {
                                    System.out.println("Wrong ID");
                                }
                            } else if (x == 2) {
                                tenant.viewFurnitures(tenant);
                                System.out.println("Enter Owner name and furniture type you want to buy or enter exit to quit:");
                                System.out.println("Owner name: ");
                                String name = scan.nextLine();
                                if (name.equals("exit"))
                                    continue;
                                System.out.println("Enter Furniture name as in the list:");
                                String f = scan.nextLine();
                                tenant.buyFurniture(tenant, name, f);
                            } else break;

                        }
                    } else continue;
                }
            }
        }