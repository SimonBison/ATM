package com.company;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-04-20.
 */
public class Bank {

    private String name;

    private ArrayList<User> users;

    private ArrayList<Account> accounts;

    public String getNewUserUUID() {

    }

    public String getNewAccountUUID() {

    }

    /**
     * Add an account
     * @param anAcct the account to add
     */
    public void addAccount(Account anAcct) {
        this.accounts.add(anAcct);
    }

}
