package com.zyy.bookstore.dao;

import com.zyy.bookstore.entity.Trade;

import java.util.Set;

public interface TradeDao {
    /**
     * 插入交易Trade对象数据
     * @param trade
     */
    void insert(Trade trade);

    /**
     * 根据用户Id查询用户对应的交易Trade集合
     * @param userId
     * @return 用户Id对应的Trade集合
     */
    Set<Trade> getTradeByUserId(int userId);
}
