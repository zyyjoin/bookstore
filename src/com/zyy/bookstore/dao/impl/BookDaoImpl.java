package com.zyy.bookstore.dao.impl;

import com.zyy.bookstore.dao.BookDao;
import com.zyy.bookstore.entity.Book;
import com.zyy.bookstore.entity.ShoppingCartItem;
import com.zyy.bookstore.web.CriteriaBook;
import com.zyy.bookstore.web.Page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookDaoImpl extends BaseDao<Book> implements BookDao{

    @Override
    public Book getBook(int id) {
        String sql = "select id,author,title,price,publishingDate," +
                "salesAmount,storeNumber,remark from mybooks where id=?";
        return query(sql,id);
    }

    @Override
    public Page<Book> getPage(CriteriaBook cb) {
        Page<Book> page = new Page<>(cb.getPageNo());
        page.setTotalItemNumber(getTotalBookNumber(cb));
        //У��pageNumber�ĺϷ���
        cb.setPageNo(page.getPageNo());
        page.setList(getPageList(cb,3));
        return page;
    }

    @Override
    public long getTotalBookNumber(CriteriaBook cb) {
        String sql = "select count(id) from mybooks where price >=? and price <=?";
        return getSingleVal(sql,cb.getMinPrice(),cb.getMaxPrice());
    }

    @Override
    public List<Book> getPageList(CriteriaBook cb, int pageSize) {
        String sql = "select id,author,title,price,publishingDate," +
                "salesAmount,storeNumber,remark from mybooks " +
                "where price>=? and price<=?" +
                "limit ?,?";
        return queryForList(sql,cb.getMinPrice(),cb.getMaxPrice(),
                (cb.getPageNo()-1)*pageSize,pageSize);
    }

    @Override
    public int getStoreNumber(int id) {
        /*Book book = this.getBook(id);
        return book.getStoreNumber();*/
        String sql = "select storeNumber from mybooks where id=?";
        return this.getSingleVal(sql,id);
    }

    @Override
    public void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> cartItems) {
        String sql = "update mybooks set salesAmount+=?,storeNumber-=? where id=?";
        Object[][] params = new Object[cartItems.size()][3];
        List<ShoppingCartItem> list = new ArrayList<>(cartItems);
        for(int i=0;i<cartItems.size();i++){
            params[i][0] = list.get(i).getQuantity();
            params[i][1] = list.get(i).getQuantity();
            params[i][2] = list.get(i).getBook().getId();
        }
        this.batch(sql,params);
    }
}
