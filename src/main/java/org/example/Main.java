package org.example;

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
            if(username.equalsIgnoreCase("exit")) {
                break;
            }
            LOGGER.info("Enter Password:");
            String password = scan.nextLine();
            loginInfo.checkAuth(username,password);
            if(!loginInfo.adminIsLogged && !loginInfo.ownerIsLogged && !loginInfo.tenantIsLogged)
                loginInfo.showError();
            else if (loginInfo.adminIsLogged){
                while (true)
                {
                    LOGGER.info("---------------Dashboard---------------");
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
                LOGGER.info("Hello tenant");
            }
            else continue;
        }
    }
}