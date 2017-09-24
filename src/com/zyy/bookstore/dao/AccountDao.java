package com.zyy.bookstore.dao;

import com.zyy.bookstore.entity.Account;

public interface AccountDao {
    /**
     * �����˻�id��ѯ�˻���Ϣ
     * @param accountId
     * @return �˻�����
     */
    Account get(int accountId);

    /**
     * �����˻�id��ָ������������˻���Ϣ
     * @param accountId
     * @param amount
     */
    void updateBalance(int accountId,float amount);
}
