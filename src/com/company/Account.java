package com.company;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-04-20.
 */
public class Account {

    private String name; // The name of the account.

    private String uuid; // The account ID number is different from the user id.

    private User holder; // Some User that holds this account.

    private ArrayList<Transaction> transactions; // A list of transactions for this account.

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

        // add account to the holder and bank lists
        // for example when I add some transactions to the account or maybe the balance of the account changes than
        // the account gets updated in both this lists below (it is not a copy it is the same account in each list)
        holder.addAccount(this);
        theBank.addAccount(this);
    }
}
