package jdbcandmybatis.mysqlutil.session;

import jdbcandmybatis.mysqlutil.binding.MapperMethod;
import jdbcandmybatis.mysqlutil.binding.MapperProxy;
import jdbcandmybatis.mysqlutil.executor.Executor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.sql.SQLException;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 16:51
 * @Version 1.0
 * 加载配置文件  ——      中转站       ——  执行器
 * configuration —— DefaultSqlSession ——  executor
 */
public class DefaultSqlSession implements SqlSession{
    //加载好的配置文件
    private Configuration configuration;
    //执行器
    private Executor executor;

    public Configuration getConfiguration() {
        return configuration;
    }

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> type){
        return (T)Proxy.newProxyInstance(type.getClassLoader(),new Class[]{type},new MapperProxy<>(this,type));
    }

    @Override
    public <T> T selectOne(MapperMethod mapperMethod,Object statement) throws Exception {
        return (T) executor.query(mapperMethod,statement);
    }
}
