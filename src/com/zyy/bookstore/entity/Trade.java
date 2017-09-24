package com.zyy.bookstore.entity;

import java.sql.Date;

/**
 * 交易类
 */
public class Trade {
    private int tradeId;//交易主键id
    private int userId;//外键关联用户类userId
    private Date tradeTime;//交易时间

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }
}
