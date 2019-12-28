package com.lzj.copy.mybatis;

import com.lzj.copy.mybatis.session.Configuration;
import com.lzj.copy.mybatis.session.DefaultSqlSession;
import com.lzj.copy.mybatis.test.mapper.UserMapper;
import com.lzj.copy.mybatis.test.pojo.User;
import com.lzj.copy.mybatis.session.SqlSessionFactory;
import com.lzj.copy.mybatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 22:36
 * @Version 1.0
 */
public class TestMysqlUtil {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = TestMysqlUtil.class.getClassLoader().getResourceAsStream("myconfig.xml");
        Configuration configuration = new Configuration();
        //把流传入到Configuration对象中
        configuration.setInputStream(inputStream);
        //把配置文件读取配置文件返回sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        //开启事务，获取加载器，返回sqlSession
        DefaultSqlSession sqlSession = (DefaultSqlSession) sqlSessionFactory.openSession(configuration);
        //调用加载器
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUser(1);
        System.out.println(user);
    }
}
