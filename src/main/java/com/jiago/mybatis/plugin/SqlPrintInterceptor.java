package com.jiago.mybatis.plugin;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.plugin2.main.server.ResultHandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @Author: LZJ
 * @Date: 2019/12/21 15:28
 * @Version 1.0
 */
@Intercepts
        ({
                @Signature(type = Executor.class,method = "query",args ={MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class} ),
                @Signature(type = Executor.class,method = "update",args ={MappedStatement.class,Object.class} )
        })
public class SqlPrintInterceptor implements Interceptor {

    private static final Logger log = LoggerFactory.getLogger(SqlPrintInterceptor.class);

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
