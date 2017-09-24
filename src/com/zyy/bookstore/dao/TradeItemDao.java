package com.zyy.bookstore.dao;

import com.zyy.bookstore.entity.TradeItem;

import java.util.Collection;
import java.util.Set;

public interface TradeItemDao {
    /**
     * ��������TradeItem��������
     * @param items
     */
    void batchSave(Collection<TradeItem> items);

    /**
     * ���ݽ���Id��ѯ��Ӧ�Ľ�����TradeItem���󼯺�
     * @param tradeId
     * @return TradeItem���󼯺�
     */
    Set<TradeItem> getTradeItemByTradeId(int tradeId);
}
