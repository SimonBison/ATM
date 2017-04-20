package com.company;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-04-20.
 */
public class Account {

    private String name; // The name of the account.

    private double balance; // The current balance of the account.

    private String uuid; // The account ID number is different from the user id.

    private User holder; // Some User that holds this account.

    private ArrayList<Transaction> transactions; // A list of transactions for this account.
}
