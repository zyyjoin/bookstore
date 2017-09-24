package com.zyy.bookstore.dao;

import com.zyy.bookstore.entity.Trade;

import java.util.Set;

public interface TradeDao {
    /**
     * ���뽻��Trade��������
     * @param trade
     */
    void insert(Trade trade);

    /**
     * �����û�Id��ѯ�û���Ӧ�Ľ���Trade����
     * @param userId
     * @return �û�Id��Ӧ��Trade����
     */
    Set<Trade> getTradeByUserId(int userId);
}
