package com.company;

import java.util.Date;

/**
 * Created by Administrator on 2017-04-20.
 */
public class Transaction {

    /**
     * The amount of this transaction.
     */
    private double amount;

    /**
     * The time and date of this transaction.
     */
    private Date timestamp;

    /**
     * A memo for this transaction.
     */
    private String memo;

    /**
     * The account in which the transaction was performed (link back to what account the transaction took place).
     */
    private Account inAccount;

}
