package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017-04-20.
 */
public class User {

    private String firstName; // The first name of the user.

    private String lastName; // The last name of the user.

    private String uuid; // unique universal identifier - it is a id code(number) for the user.

    private byte pinHash[]; // storing user pin information.

    private ArrayList<Account> accounts; // The list of accounts for this user.

    /** Header comment for the constructor.
     * Create a new user
     * @param firstName the user's first name
     * @param lastName  the user's last name
     * @param pin       the user's account pin number
     * @param theBank   the Bank object that the user is a customer of
     */
    // creating the constructor for the user
    public User(String firstName, String lastName, String pin, Bank theBank) {

        // set the user's name
        this.firstName = firstName;
        this.lastName = lastName;

        // store the pin's MD5 hash, rather than the original value, for security reasons
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        // get a new, unique universal ID for the user
        this.uuid = theBank.getNewUserUUID();

        // create empty list of accounts (constructor for the array list)
        this.accounts = new ArrayList<Account>();

        // print out a log message (to know what the uuid is
        System.out.printf("New user %s, %s with ID %s created. \n", lastName, firstName);

    }

}
