package com.zyy.bookstore.entity;

/**
 * 账户类
 */
public class Account {
    private int accountId;//主键Id
    private float balance;//余额

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
