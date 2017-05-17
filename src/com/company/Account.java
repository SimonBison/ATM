package com.company;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-04-20.
 */
public class Account {

    /**
     * The name of the account.
     */
    private String name;

    /**
     * The account ID number (different from the user id).
     */
    private String uuid;

    /**
     * The User object that owns thos account (Some User that holds this account).
     */
    private User holder;

    /**
     * A list of transactions for this account.
     */
    private ArrayList<Transaction> transactions;

    /**
     * Create a new Account
     * @param name      the name of the account
     * @param holder    the User object that holds this account
     * @param theBank   the bank that issues the account
     */

    // creating the account constructor
    public Account(String name, User holder, Bank theBank) {

        // set the account name and holder
        this.name = name;
        this.holder = holder;

        // get new account UUID
        this.uuid = theBank.getNewAccountUUID();

        // initialize transactions to an empty list
        this.transactions = new ArrayList<Transaction>();

    }

    /**
     * Get the account ID
     * @return the uuid
     */
    public String getUUID() {
        return this.uuid;
    }
}
