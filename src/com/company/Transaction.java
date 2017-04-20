package com.company;

import java.util.Date;

/**
 * Created by Administrator on 2017-04-20.
 */
public class Transaction {

    private double amount; // The amount of this transaction.

    private Date timestamp; // The time and date of this transaction.

    private String memo; // A memo for this transaction.

    private Account inAccount;   // link back to what account the transaction took place.


}
