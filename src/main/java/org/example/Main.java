package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static Scanner scan=new Scanner(System.in);
    static LoginInfo loginInfo = new LoginInfo();
    public static void main(String[] args) {
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
                LOGGER.info("Hello Owner");
            }
            else if (loginInfo.tenantIsLogged){
                while (true)
                {
                    LOGGER.info("--------------- Dashboard ---------------");
                    LOGGER.info("1- View the available housing.");
                    LOGGER.info("2- My booking.");
                    LOGGER.info("3- Setting");
                    LOGGER.info("4- Sign out");
                    String open=scan.nextLine();

                    if (open.equals("1")){
                        while (true){
                            loginInfo.showHousing();
                            String selectHousing = scan.nextLine(); // 1, 2, 3, ...

                            if (selectHousing.equals("0")) break;
                            while (true){
                                LOGGER.info("--------------- House "+ selectHousing +" ---------------");
                                LOGGER.info("1- View pictures.");
                                LOGGER.info("2- View details.");
                                LOGGER.info("3- Booking.");
                                LOGGER.info("4- Go bake.");
                                String house = scan.nextLine();

                                if (house.equals("1")){
//                                    String imageUrl = "C:\\Users\\AB\\Sakanaty\\src\\main\\resources\\IMGE\\zz111.jpg";
//                                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageUrl).getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT));
//                                    JLabel imageLabel = new JLabel(imageIcon);
//
//                                    JFrame frame = new JFrame();
//                                    frame.add(imageLabel);
//                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                                    frame.pack();
//                                    frame.setVisible(true);
                                }
                                else if (house.equals("2")) {
                                    loginInfo.showDetails(loginInfo.findHousingByNumRow(house));
                                }
                                else if (house.equals("3")) {

                                }
                                else if (house.equals("4")) break;
                                else continue;
                            }
                        }
                    }
                    else if (open.equals("2"))
                    {

                    }
                    else if (open.equals("3"))
                    {

                    }
                    else if (open.equals("4")) break;
                    else continue;

                }
            }
            else continue;
        }
    }
}