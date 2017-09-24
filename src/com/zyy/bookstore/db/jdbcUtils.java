package com.zyy.bookstore.db;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zyy.bookstore.exception.DBException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC工具类
 */
public class jdbcUtils {
    private static DataSource dateSource = null;
    static {
        dateSource = new ComboPooledDataSource("bookstore");
    }
    //获取数据库连接
    public static Connection getConnection(){
        try {
            return dateSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("数据库获取连接错误！");
        }
    }
    //释放数据库连接
    public static void release(Connection connection){
        try {
            if(connection != null){
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("数据库释放连接错误！");
        }
    }
    //释放其他数据库资源
    public static void release(Statement statement, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if (statement != null){
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("数据库释放其他资源错误！");
        }
    }
}
