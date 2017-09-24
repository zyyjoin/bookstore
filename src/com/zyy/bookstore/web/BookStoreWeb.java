package com.zyy.bookstore.web;

import com.zyy.bookstore.entity.ShoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BookStoreWeb {
    /**
     * 从session中获取购物车对象
     * 如果session中没有该对象，就创建一个购物车对象，放入session
     * @param request
     * @return
     */
    public static ShoppingCart getShoppingCart(HttpServletRequest request){
        HttpSession session = request.getSession();

        ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
        if (cart == null){
            cart = new ShoppingCart();
            session.setAttribute("cart",cart);
        }
        return cart;
    }
}
