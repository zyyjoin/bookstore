package com.zyy.bookstore.service;

import com.zyy.bookstore.dao.BookDao;
import com.zyy.bookstore.dao.impl.BookDaoImpl;
import com.zyy.bookstore.entity.Book;
import com.zyy.bookstore.entity.ShoppingCart;
import com.zyy.bookstore.web.CriteriaBook;
import com.zyy.bookstore.web.Page;

public class BookService {
    private BookDao bookDao = new BookDaoImpl();
    public Page<Book> getPage(CriteriaBook criteriaBook){
        return bookDao.getPage(criteriaBook);
    }
    public Book getBook(int id){
        return bookDao.getBook(id);
    }

    public boolean addToCart(int id, ShoppingCart cart){
        Book book = bookDao.getBook(id);
        if(book != null){
            cart.addBook(book);
            return true;
        }
        return false;
    }
}
