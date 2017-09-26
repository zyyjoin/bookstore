package com.zyy.bookstore.servlet;

import com.zyy.bookstore.entity.Book;
import com.zyy.bookstore.entity.ShoppingCart;
import com.zyy.bookstore.service.BookService;
import com.zyy.bookstore.web.BookStoreWeb;
import com.zyy.bookstore.web.CriteriaBook;
import com.zyy.bookstore.web.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "BookServlet")
public class BookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private BookService bookService = new BookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String methodName = request.getParameter("method");
        try {
            Method method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void cartClear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCart cart = BookStoreWeb.getShoppingCart(request);
        bookService.cartClear(cart);
        request.getRequestDispatcher("/WEB-INF/pages/empty.jsp").forward(request,response);

    }
    protected void cartRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String idStr=request.getParameter("id");

        int id=-1;
        try {
            id=Integer.parseInt(idStr);
        } catch (NumberFormatException e) {}

        ShoppingCart cart = BookStoreWeb.getShoppingCart(request);
        bookService.removeItemFromShoppingCart(cart,id);

        if(cart.isEmpty()){
            request.getRequestDispatcher("/WEB-INF/pages/empty.jsp").forward(request,response);
        }else 
        //重新回到购物车页面
        request.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(request,response);

    }
    protected void toCartPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //服务器转发
        request.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(request,response);
    }

    protected void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取商品id
        String idStr = request.getParameter("id");
        int id = -1;//如果id值没取到
        Book book = null;
        boolean flag = false;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {}
        if(id>0){
            //2.获取购物车对象
            ShoppingCart cart = BookStoreWeb.getShoppingCart(request);
            //3.调用BookService中的addToCart()方法
            flag = bookService.addToCart(id,cart);
        }
        if(flag){
            //4.直接调用getbooks()方法（页面跳转到books.jsp（这种方式不行））
            getBooks(request,response);
            return;
        }
        response.sendRedirect(request.getContextPath() +"/error.jsp");

    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = -1;//如果id值没取到
        Book book = null;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            //id值不合法
        }
        if (id>0){
            book = bookService.getBook(id);//涉及查询数据库
        }
        if (book == null){
            response.sendRedirect(request.getContextPath() +"/error.jsp");
            return;
        }
        request.setAttribute("book",book);

        request.getRequestDispatcher("/WEB-INF/pages/book.jsp").forward(request, response);
    }
    protected void getBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 封装CriteriaBook对象
         */
        String pageNoStr = request.getParameter("pageNo");
        String minPriceStr = request.getParameter("minPrice");
        String maxPriceStr = request.getParameter("maxPrice");

        int pageNo = 1;
        int minPrice = 0;
        int maxPrice = Integer.MAX_VALUE;
        //赋值
        try {
            pageNo = Integer.parseInt(pageNoStr);
        } catch (NumberFormatException e) {}
        try {
            minPrice = Integer.parseInt(minPriceStr);
        } catch (NumberFormatException e) {}
        try {
            maxPrice = Integer.parseInt(maxPriceStr);
        } catch (NumberFormatException e) {}

        CriteriaBook criteriaBook = new CriteriaBook(minPrice, maxPrice, pageNo);

        Page<Book> page = bookService.getPage(criteriaBook);

        request.setAttribute("bookpage", page);

        request.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(request, response);
    }
}
