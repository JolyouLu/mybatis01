package com.lzj.copy.mybatis.session;

import java.io.IOException;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 21:17
 * @Version 1.0
 * 用于返回我们的SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    //加载配置文件 返回SqlSessionFactory对象
    public SqlSessionFactory build(Configuration configuration) throws IOException {
        //读取xml
        configuration.loadConfigurations();
        return new SqlSessionFactory();
    }
}
