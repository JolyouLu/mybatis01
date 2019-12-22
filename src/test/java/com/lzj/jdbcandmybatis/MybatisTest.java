package com.lzj.jdbcandmybatis;

import com.lzj.jdbcandmybatis.mybatis.mapper.UserMapper;
import com.lzj.jdbcandmybatis.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: LZJ
 * @Date: 2019/12/21 15:01
 * @Version 1.0
 */
public class MybatisTest {

    @Test //使用xml编写sql查询
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        //读取resources下的mybatis-config.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //com.jiago.mybatis.UserMapper.selectUser  UserMapper.xml下的id为selectUser的语句
        User user = sqlSession.selectOne("com.jiago.mybatis.UserMapper.selectUser", 1);
        System.out.println("查询结果："+user);
    }

    @Test //使用注解编写sql查询
    public void test2() throws IOException {
        String resource = "mybatis-config.xml";
        //读取resources下的mybatis-config.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUser(1);
        System.out.println("查询结果："+user);
    }
}
