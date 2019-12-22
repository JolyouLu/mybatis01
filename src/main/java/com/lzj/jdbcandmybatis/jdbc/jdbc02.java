package com.lzj.jdbcandmybatis.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: LZJ
 * @Date: 2019/12/21 13:54
 * @Version 1.0
 */
public class jdbc02 {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("test02");
        user.setAge(18);
        insert(user);//插入数据方法
        User query = query(1);
        System.out.println("查询成功结果如下！");
        System.out.println(query);

    }

    static void insert(User user){
        //定义需要执行的sql
        String sql="insert into user(username,age) value(?,?)";
        //打开数据库连接
        Connection conn = DbUtil.open();
        try {
            PreparedStatement pstmt =(PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setInt(2, user.getAge());
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbUtil.close(conn);
        }
    }

    static User query(int id){
        String sql="select * from user where id=?";
        Connection conn = DbUtil.open();
        try {
            PreparedStatement pstmt =(PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                String name = rs.getString(2);
                User user = new User();
                user.setId(id);
                user.setUsername(name);
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbUtil.close(conn);
        }
        return null;
    }
}
