package com.zyy.bookstore.dao.impl;

import com.zyy.bookstore.dao.Dao;
import com.zyy.bookstore.db.jdbcUtils;
import com.zyy.bookstore.utils.ReflectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class BaseDao<T> implements Dao<T> {
    public QueryRunner queryRunner = new QueryRunner();

    private Class<T> clazz;

    public BaseDao() {
        clazz = ReflectionUtils.getSuperGenericType(getClass());
    }

    @Override
    public long insert(String sql, Object... args) {
        long id = 0;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = jdbcUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            if (args != null){
                for (int i = 0;i<args.length;i++){
                    preparedStatement.setObject(i+1,args[i]);
                }
            }
            preparedStatement.executeUpdate();
            //获取产生的主键id值
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
               id = resultSet.getLong(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtils.release(conn);
            jdbcUtils.release(preparedStatement,resultSet);
        }
        return id;
    }

    @Override
    public void update(String sql, Object... args) {
        Connection conn = null;
        try {
            conn = jdbcUtils.getConnection();
            queryRunner.update(conn,sql,args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtils.release(conn);
        }
    }

    @Override
    public T query(String sql, Object... args) {
        Connection conn = null;
        try {
            conn = jdbcUtils.getConnection();
            return queryRunner.query(conn,sql,new BeanHandler<T>(clazz),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtils.release(conn);
        }
        return null;
    }

    @Override
    public List<T> queryForList(String sql, Object... args) {
        Connection conn = null;
        try {
            conn = jdbcUtils.getConnection();
            return queryRunner.query(conn,sql,new BeanListHandler<>(clazz),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtils.release(conn);
        }
        return null;
    }

    @Override
    public void batch(String sql, Object[]... params) {
        Connection conn = null;
        try {
            conn = jdbcUtils.getConnection();
            queryRunner.batch(conn,sql,params);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtils.release(conn);
        }
    }

    @Override
    public <V> V getSingleVal(String sql, Object... args) {
        Connection conn = null;
        try {
            conn = jdbcUtils.getConnection();
            return (V)queryRunner.query(conn,sql,new ScalarHandler(),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtils.release(conn);
        }
        return null;
    }
}

