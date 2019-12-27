package com.lzj.copy.mybatis.session;

import com.lzj.copy.mybatis.executor.Executor;
import com.lzj.copy.mybatis.binding.MapperMethod;
import com.lzj.copy.mybatis.binding.MapperProxy;

import java.lang.reflect.Proxy;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 16:51
 * @Version 1.0
 * SqlSession存放着 configuration executor
 * 先把配置文件加载入configuration
 * 通过SqlSession 调用executor执行器 执行sql
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
    //使用动态代理 代理给MapperProxy
    public <T> T getMapper(Class<T> type){
        return (T)Proxy.newProxyInstance(type.getClassLoader(),new Class[]{type},new MapperProxy<>(this,type));
    }

    @Override //实现SqlSession接口种的 selectOne方法
    public <T> T selectOne(MapperMethod mapperMethod,Object statement) throws Exception {
        return (T) executor.query(mapperMethod,statement);
    }
}
