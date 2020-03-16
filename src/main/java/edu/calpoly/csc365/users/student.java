package edu.calpoly.csc365.users;

import edu.calpoly.csc365.dao.DaoManager;
import edu.calpoly.csc365.entity.User;

import java.sql.Connection;
import java.util.Scanner;

public class student {
    public static int mainStudent(Connection myConn){
        String username, permLevel;
        Scanner inputScanner = new Scanner(System.in);
        User u;

        System.out.print("You are a Student, please enter your username: ");
        username = inputScanner.nextLine();
        System.out.print("Please enter your student level (UG, GR): ");
        permLevel = inputScanner.nextLine();

        u = DaoManager.verifyUser(username, permLevel, myConn);

        if(u.getId() !=  null)
            System.out.println("Valid user: " + u.getId());
        else
            System.out.println("Invalid user");

        return 1;
    }
}
