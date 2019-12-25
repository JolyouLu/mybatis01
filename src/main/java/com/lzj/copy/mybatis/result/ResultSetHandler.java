package com.lzj.copy.mybatis.result;

import com.lzj.copy.mybatis.binding.MapperMethod;

import java.sql.PreparedStatement;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 22:49
 * @Version 1.0
 */
public interface ResultSetHandler {
    public <T> T handle(PreparedStatement pstmt, MapperMethod mapperMethod) throws Exception;
}
