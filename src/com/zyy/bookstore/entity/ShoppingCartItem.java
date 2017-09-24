package com.zyy.bookstore.entity;

/**
 * 购物车项（不包含价格）类，包括书和购买数量
 */
public class ShoppingCartItem {
    private Book book;
    private int quantity;//购买数量

    public ShoppingCartItem(Book book) {
        this.book = book;
        this.quantity = 1;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * 计算一个购物项的总价格
     * @return
     */
    public float getItemMoney() {
        return book.getPrice() * quantity;
    }

    /**
     *  购买数量加一
     */
    public void increment() {
        quantity++;
    }
}
