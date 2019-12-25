package com.lzj.copy.mybatis.test.mapper;


import com.lzj.copy.mybatis.test.pojo.User;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 22:41
 * @Version 1.0
 */
public interface UserMapper {
    public User getUser(Integer id);
}
