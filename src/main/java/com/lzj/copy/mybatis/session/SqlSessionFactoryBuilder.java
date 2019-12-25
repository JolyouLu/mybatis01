package com.lzj.copy.mybatis.session;

import java.io.IOException;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 21:17
 * @Version 1.0
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(Configuration configuration) throws IOException {
        configuration.loadConfigurations();
        return new SqlSessionFactory();
    }
}
