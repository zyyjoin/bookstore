package com.zyy.bookstore.dao;

import com.zyy.bookstore.entity.Book;
import com.zyy.bookstore.entity.ShoppingCartItem;
import com.zyy.bookstore.web.CriteriaBook;
import com.zyy.bookstore.web.Page;

import java.util.Collection;
import java.util.List;

public interface BookDao {
    /**
     * 根据id获取指定书
     * @param id 书类主键id
     * @return 对应书对象
     */
    Book getBook(int id);
    /**
     * 根据CriteriaBook对象查询对应的Page
     * @param cb
     * @return
     */
    Page<Book> getPage(CriteriaBook cb);
    /**
     * 根据CriteriaBook对象返回对应的记录总数
     * @param cb
     * @return
     */
    long getTotalBookNumber(CriteriaBook cb);
    /**
     * 根据CriteriaBook对象和pageSize返回当前页对应的List
     * @param cb
     * @param pageSize
     * @return
     */
    List<Book> getPageList(CriteriaBook cb,int pageSize);

    /**
     * 查询指定书id的库存storeNumber值
     * @param bookId
     * @return 返回库存数
     */
    int getStoreNumber(int bookId);

    /**
     * 根据购物车项集合批量更新书Book数据表的库存StoreNumber、销售额salesNumber值
     * @param cartItems
     */
    void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> cartItems);

}
