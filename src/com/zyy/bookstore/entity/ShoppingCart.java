package com.zyy.bookstore.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 购物车类，包含多个购物项，可以添加和删除某个购物项
 * 考虑到易于删除，使用Map<Integer,ShoppingCartItem>集合存储
 */
public class ShoppingCart {
    private Map<Integer, ShoppingCartItem> books = new HashMap<>();

    /**
     *  修改某个购物项的购买数量
     * @param id
     * @param quantity
     */
    public void updateItemQuantity(Integer id, int quantity){
        ShoppingCartItem cartItem =books.get(id);
        if(cartItem != null){
            cartItem.setQuantity(quantity);
        }
    }

    /**
     *  删除单个购物项
     * @param id
     */
    public void removeItem(Integer id){
        books.remove(id);
    }

    /**
     *  清空购物车
     */
    public void clear(){
        books.clear();
    }

    /**
     *  购物车是不是空的
     * @return
     */
    public boolean isEmpty(){
        return books.isEmpty();
    }

    /**
     *  购物车总金额
     * @return
     */
    public float getTotalMoney(){
        float total = 0;

        for(ShoppingCartItem cartItem: getItems()){
            total += cartItem.getItemMoney();
        }

        return total;
    }

    /**
     * 获取购物车中所有购物项的集合
     * @return
     */
    public Collection<ShoppingCartItem> getItems(){
        return books.values();
    }

    /**
     *  返回购物车中商品的总数量
     * @return
     */
    public int getBookNumber(){
        int total = 0;

        for(ShoppingCartItem cartItem: books.values()){
            total += cartItem.getQuantity();
        }

        return total;
    }

    public Map<Integer, ShoppingCartItem> getBooks() {
        return books;
    }

    /**
     *  查看购物车是否有指定id的书
     * @param id
     * @return
     */
    public boolean hasBook(Integer id){
        return books.containsKey(id);
    }

    /**
     *  添加书到购物车
     * @param book
     */
    public void addBook(Book book){
        //1.先判断购物车中是否已经有该商品了。没有就添加，有了就数量加一就行了
        ShoppingCartItem cartItem = books.get(book.getId());

        if(cartItem == null){
            cartItem = new ShoppingCartItem(book);
            books.put(book.getId(), cartItem);
        }else{
            cartItem.increment();
        }
    }

}
