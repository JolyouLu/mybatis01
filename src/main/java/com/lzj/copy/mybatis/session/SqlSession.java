package com.lzj.copy.mybatis.session;

import com.lzj.copy.mybatis.binding.MapperMethod;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 17:39
 * @Version 1.0
 */
public interface SqlSession {
    <T> T selectOne(MapperMethod mapperMethod, Object statement) throws Exception;
}
