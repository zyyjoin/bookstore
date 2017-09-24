package com.zyy.bookstore.dao.impl;

import com.zyy.bookstore.dao.UserDao;
import com.zyy.bookstore.entity.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao{

    @Override
    public User getUser(int username) {
        String sql = "select userId,username,accountId from userinfo where username=?";
        return this.query(sql,username);
    }
}
