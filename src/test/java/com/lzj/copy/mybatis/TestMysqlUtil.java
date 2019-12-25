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
        configuration.setInputStream(inputStream);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        DefaultSqlSession sqlSession = (DefaultSqlSession) sqlSessionFactory.openSession(configuration);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUser(1);
        System.out.println(user);
    }
}
