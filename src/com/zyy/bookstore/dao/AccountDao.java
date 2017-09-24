package com.zyy.bookstore.dao;

import com.zyy.bookstore.entity.Account;

public interface AccountDao {
    /**
     * 根据账户id查询账户信息
     * @param accountId
     * @return 账户对象
     */
    Account get(int accountId);

    /**
     * 根据账户id和指定金额数更新账户信息
     * @param accountId
     * @param amount
     */
    void updateBalance(int accountId,float amount);
}
