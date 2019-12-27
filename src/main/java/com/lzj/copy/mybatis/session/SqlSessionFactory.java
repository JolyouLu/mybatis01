package com.lzj.copy.mybatis.session;

import com.lzj.copy.mybatis.executor.SimpleExecutor;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 21:13
 * @Version 1.0
 * 用于返回我们的SqlSession对象
 */
public class SqlSessionFactory {
    //把配置文件和执行器传入 返回SqlSession
    public SqlSession openSession(Configuration configuration){
        return new DefaultSqlSession(configuration,new SimpleExecutor(configuration));
    }
}
