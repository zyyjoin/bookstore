package com.zyy.bookstore.test;

import com.zyy.bookstore.dao.BookDao;
import com.zyy.bookstore.dao.impl.BookDaoImpl;
import com.zyy.bookstore.entity.Book;
import com.zyy.bookstore.web.CriteriaBook;
import com.zyy.bookstore.web.Page;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookDaoImplTest {
    private BookDao bookDao = new BookDaoImpl();
    private CriteriaBook criteriaBook = new CriteriaBook(50,60,5);
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getBook() throws Exception {
        Book book = bookDao.getBook(1);
        System.out.println(book.toString());
    }

    @Test
    public void getPage() throws Exception {
        Page<Book> page = bookDao.getPage(criteriaBook);
        System.out.println("pageNo "+page.getPageNo());
        System.out.println("totalPageNumber "+page.getTotalPageNumber());
        System.out.println("list "+page.getList());
        System.out.println("prePage "+page.getPrePage());
        System.out.println("nextPage "+page.getNextPage());
    }

    @Test
    public void getTotalBookNumber() throws Exception {
    }

    @Test
    public void getPageList() throws Exception {
    }

    @Test
    public void getStoreNumber() throws Exception {
    }

    @Test
    public void batchUpdateStoreNumberAndSalesAmount() throws Exception {
    }

}