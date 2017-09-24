package com.zyy.bookstore.dao;

import java.util.List;

/**
 * Dao接口，定义对数据库的基本操作，由BaseDao提供实现
 * @param <T> Dao实际操作的泛型类型
 */
public interface Dao<T> {
    /**
     * 插入数据，返回插入后记录的ID
     * @param sql 执行的sql语句
     * @param args 填充占位符的可变参数
     * @return 插入后记录的ID
     */
    long insert(String sql,Object...args);
    /**
     * 修改数据(包括 INSERT(但没有返回值), UPDATE, DELETE)
     * @param sql
     * @param args
     */
    void update(String sql,Object...args);
    /**
     * 查询单条数据，返回记录所对应的对象
     * @param sql
     * @param args
     * @return 记录所对应的对象
     */
    T query(String sql,Object...args);
    /**
     * 查询多条数据，返回多条记录对应的对象list集合
     * @param sql
     * @param args
     * @return 多条记录对应的对象list集合
     */
    List<T> queryForList(String sql,Object...args);
    /**
     * 对一个属性或值的查询，返回要查询的某一个值
     * @param sql
     * @param args
     * @param <V>
     * @return 要查询的值
     */
    <V> V getSingleVal(String sql,Object...args);
    /**
     * 批量更新数据
     * @param sql
     * @param params
     */
    void batch(String sql,Object[]...params);
}
