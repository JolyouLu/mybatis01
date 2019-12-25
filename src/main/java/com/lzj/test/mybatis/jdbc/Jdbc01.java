package com.lzj.test.mybatis.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: LZJ
 * @Date: 2019/12/21 13:54
 * @Version 1.0
 * 使用传统的insert方法
 */
public class Jdbc01 {
    public static void main(String[] args) {
        insert("test01",12);
    }
    //新增数据方法
    static void insert(String name,int age){
        //定义需要执行的sql
        String sql="insert into user(username,age) value(?,?)";
        //打开数据库连接
        Connection conn = DbUtil.open();
        try {
            PreparedStatement pstmt =(PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbUtil.close(conn);
        }
    }
}
