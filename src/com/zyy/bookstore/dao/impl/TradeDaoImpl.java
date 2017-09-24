package com.zyy.bookstore.dao.impl;

import com.zyy.bookstore.dao.TradeDao;
import com.zyy.bookstore.entity.Trade;

import java.util.LinkedHashSet;
import java.util.Set;

public class TradeDaoImpl extends BaseDao<Trade> implements TradeDao {
    @Override
    public void insert(Trade trade) {
        String sql = "insert into trade (userid,tradetime) values (?,?)";
        long tradeId = this.insert(sql,trade.getTradeId(),trade.getTradeTime());
        trade.setTradeId((int)tradeId);
    }

    @Override
    public Set<Trade> getTradeByUserId(int userId) {
        String sql = "select tradeid,userid,tradetime from trade where userid=?";
        return new LinkedHashSet(this.queryForList(sql,userId));
    }
}
