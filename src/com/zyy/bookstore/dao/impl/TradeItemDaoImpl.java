package com.zyy.bookstore.dao.impl;

import com.zyy.bookstore.dao.TradeItemDao;
import com.zyy.bookstore.entity.TradeItem;

import java.util.*;

public class TradeItemDaoImpl extends BaseDao implements TradeItemDao {
    @Override
    public void batchSave(Collection<TradeItem> items) {
        String sql = "insert into tradeitem (bookid,quantity,tradeId) values (?,?,?)";
        Object[][] params = new Object[items.size()][3];
        List<TradeItem> tradeItems = new ArrayList<>(items);
        for(int i=0;i<items.size();i++){
            params[i][0] = tradeItems.get(i).getBookId();
            params[i][1] = tradeItems.get(i).getQuantity();
            params[i][2] = tradeItems.get(i).getTradeId();
        }
        this.batch(sql,params);
    }

    @Override
    public Set<TradeItem> getTradeItemByTradeId(int tradeId) {
        String sql = "select itemid,bookid,quantity,tradeId from tradeitem where tradeid=?";
        return new HashSet<>(this.queryForList(sql,tradeId));
    }
}
