package com.lzj.jdbcandmybatis.mybatis.mapper;

import com.lzj.jdbcandmybatis.mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: LZJ
 * @Date: 2019/12/21 15:14
 * @Version 1.0
 */
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    public User selectUser(Integer id);
}
