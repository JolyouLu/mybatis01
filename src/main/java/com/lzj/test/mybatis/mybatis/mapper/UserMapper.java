package com.lzj.test.mybatis.mybatis.mapper;

import com.lzj.test.mybatis.mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: LZJ
 * @Date: 2019/12/21 15:14
 * @Version 1.0
 * mybatis使用注解式开发
 */
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    public User selectUser(Integer id);
}
