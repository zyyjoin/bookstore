package com.zyy.bookstore.test;

import com.zyy.bookstore.dao.impl.BaseDao;
import com.zyy.bookstore.dao.impl.BookDaoImpl;
import com.zyy.bookstore.entity.Book;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

public class BaseDaoTest {

    private BookDaoImpl bookDaoImpl= new BookDaoImpl();
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        String sql = "insert into trade (userid,tradetime) values(?,?)";
        long id = bookDaoImpl.insert(sql,1,new Date(new java.util.Date().getTime()));
        System.out.println(id);
    }

    @Test
    public void update() throws Exception {
        String sql = "update mybooks set salesAmount=? where id=?";
        bookDaoImpl.update(sql,35,4);
    }

    @Test
    public void query() throws Exception {
        String sql = "select id,author,title,price,publishingDate," +
                "salesAmount,storeNumber,remark from mybooks where id=?";
        Book book = bookDaoImpl.query(sql,"2");
        System.out.println(book.toString());
    }

    @Test
    public void queryForList() throws Exception {
        String sql = "select id,author,title,price,publishingDate," +
                "salesAmount,remark from mybooks where id<?";
        List<Book> books = bookDaoImpl.queryForList(sql,4);
        System.out.println(books);
    }

    @Test
    public void batch() throws Exception {
        String sql = "update mybooks set salesAmount=?,storeNumber=? where id = ? ";
        bookDaoImpl.batch(sql,new Object[]{1,1,1},new Object[]{2,2,2},new Object[]{3,3,3});
    }

    @Test
    public void getSingleVal() throws Exception {
        String sql = "select count(id) from mybooks";
        long count = bookDaoImpl.getSingleVal(sql);
        System.out.println(count);
    }

}