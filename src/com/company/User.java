package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017-04-20.
 */
public class User {

    /**
     * The first name of the user.
     */
    private String firstName;

    /**
     * The last name of the user.
     */
    private String lastName;

    /**
     * The ID number of the user. - Unique universal identifier - it is a id code(number) for the user.
     */
    private String uuid;

    /**
     * The MD5 hash of the user's pin number.(storing user pin information)
     */
    private byte pinHash[];

    /**
     * The list of accounts for this user.
     */
    private ArrayList<Account> accounts;

    /**
     * Header comment for the constructor.
     * Create a new user
     *
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

        // print out a log message (to know what the uuid is)
        System.out.printf("New user %s, %s with ID %s created. \n", lastName, firstName, this.uuid);

    }

    /**
     * Add an account for the user
     * @param anAcct the account to add
     */
    public void addAccount(Account anAcct) {
        this.Account.add(anAcct);               // using encapsulation
    }

    /**
     * Return the user's UUID
     * @return the uuid
     */
    public String getUUID() {
        return this.uuid;
    }

    /**
     * Check whether a given pin matches the true User pin
     * @param aPin  the pin to check
     * @return      whether the pin is valid or not
     */
    public boolean validatePin(String aPin){

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()),
                    this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        return false;
    }

    /**
     * Retrun the user's first name.
     * @return  the first name
     */
    public String getFirstName(){
        return this.firstName;
    }
}
