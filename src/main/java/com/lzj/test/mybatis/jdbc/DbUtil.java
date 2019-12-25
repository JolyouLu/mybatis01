package com.lzj.test.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: LZJ
 * @Date: 2019/12/21 13:53
 * @Version 1.0
 * 传统的jdbc连接数据库工具类
 */
public class DbUtil {
    /**
     * 打开数据库
     */
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        driver="com.mysql.jdbc.Driver";//数据库驱动
        url="jdbc:mysql://localhost:3306/study?characterEncoding=utf8&useSSL=true";
        username="root";
        password="123456";
    }

    /**
     * 加载数据库驱动 并且连接数据库
     */
    public static Connection open(){
        try {
            Class.forName(driver);
            return (Connection) DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭数据库连接
     */
    public static void close(Connection conn){
        if (conn !=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}
