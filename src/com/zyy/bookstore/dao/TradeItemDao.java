package com.zyy.bookstore.dao;

import com.zyy.bookstore.entity.TradeItem;

import java.util.Collection;
import java.util.Set;

public interface TradeItemDao {
    /**
     * 批量保存TradeItem对象数据
     * @param items
     */
    void batchSave(Collection<TradeItem> items);

    /**
     * 根据交易Id查询对应的交易项TradeItem对象集合
     * @param tradeId
     * @return TradeItem对象集合
     */
    Set<TradeItem> getTradeItemByTradeId(int tradeId);
}
