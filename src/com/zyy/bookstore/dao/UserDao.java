package com.zyy.bookstore.dao;

import com.zyy.bookstore.entity.User;

public interface UserDao {

    /**
     * �����û�����ȡUser��������
     * @param username
     * @return �û�User����
     */
    User getUser(int username);
}
