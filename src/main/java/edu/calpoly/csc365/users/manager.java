package edu.calpoly.csc365.users;

import edu.calpoly.csc365.dao.DaoManager;
import edu.calpoly.csc365.entity.User;

import java.sql.Connection;
import java.util.Scanner;

public class manager {
    public static int mainManager(Connection myConn){
        String username, permLevel = "MAN";
        Scanner inputScanner = new Scanner(System.in);
        User u;

        System.out.print("You are a Manager, please enter your username: ");
        username = inputScanner.nextLine();

        u = DaoManager.verifyUser(username, permLevel, myConn);

        if(u.getId() !=  null)
            System.out.println("Valid user: " + u.getId());
        else
            System.out.println("Invalid user");

        return 1;
    }
}
