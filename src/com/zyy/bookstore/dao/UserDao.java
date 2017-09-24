package com.zyy.bookstore.dao;

import com.zyy.bookstore.entity.User;

public interface UserDao {

    /**
     * 根据用户名获取User对象数据
     * @param username
     * @return 用户User对象
     */
    User getUser(int username);
}
