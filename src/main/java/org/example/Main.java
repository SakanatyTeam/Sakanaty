package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            LOGGER.info("Enter username:");
            String username=scan.nextLine().trim().strip();
            if(username.equalsIgnoreCase("exit")) {
                break;
            }
            LOGGER.info("Enter Password:");
//            myAppInfo.loggInCheck(username,scan.nextLine());
//            if(!myAppInfo.isLoggedIn())
//            {
//                myAppInfo.refuseLoggIn();
//                continue;
//            }

        }
    }
}