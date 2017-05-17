package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // init Scanner
        Scanner sc = new Scanner(System.in);

        // init Bank
        Bank theBank = new Bank("Bank of Wroclaw");

        // add a user, which also creates a savings account
        User aUser = theBank.addUser("John", "Rambo", "4321" );

        // add a checking account for our user
        Account newAccount = new Account("Checking", aUser, theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        while (true) {

            // stay in the login prompt until successful login
            curUser = Main.mainMenuPrompt(theBank, sc);

            // stay in main menu until user quits
            Main.printUserMenu(curUser, sc);
        }
    }

    /**
     * Print the ATM's login menu
     * @param theBank the Bank object whose accounts to use
     * @param sc      the Scanner object to use for user input
     * @return        the authenticated User object
     */
    public static User mainMenuPrompt(Bank theBank, Scanner sc) {

        // inits
        String userID;
        String pin;
        User authUser;

        // prompt the user for ID/pin combo until a correct one is reached
        do {

            System.out.println("\n\nWelcome to %s\n\n", theBank.getName());
            System.out.println("Enter user ID: ");
            userID = sc.nextLine();
            System.out.println("Enter pin: ");
            pin = sc.nextLine();

            // try to get user object corresponding to the ID and pin combo
            authUser = theBank.userLogin(userID, pin);
            if (authUser == null) {
                System.out.println("Incorret user ID/pin combination. " + "Please try again.");
            }

        } while(authUser == null); // continue looping until successful login

        return authUser;
    }
}
