package com.zyy.bookstore.entity;

/**
 * 用户类User
 */
public class User {
    private int userId;//主键Id
    private String username;//用户名
    private int accountId;//外键关联账户类accountId

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
