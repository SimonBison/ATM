package com.company;

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

}
