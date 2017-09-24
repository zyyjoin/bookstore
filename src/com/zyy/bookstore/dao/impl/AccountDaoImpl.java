package com.zyy.bookstore.dao.impl;

import com.zyy.bookstore.dao.AccountDao;
import com.zyy.bookstore.entity.Account;

public class AccountDaoImpl extends BaseDao<Account> implements AccountDao {
    @Override
    public Account get(int accountId) {
        String sql = "select accountId,balance from account where accountId = ?";
        return this.query(sql,accountId);
    }

    @Override
    public void updateBalance(int accountId, float amount) {
        String sql = "update account set balance = ? where accountId = ?";
        this.update(sql,amount,accountId);
    }
}
