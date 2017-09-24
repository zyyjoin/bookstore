package com.zyy.bookstore.entity;

/**
 * 交易项类
 */
public class TradeItem {
    private int itemId;//交易项主键id
    private int bookId;//外键关联书类Id
    private int quantity;//数量
    private int tradeId;//外键关联交易类tradeId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }
}
