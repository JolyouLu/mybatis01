package com.lzj.copy.mybatis.executor;

import com.lzj.copy.mybatis.session.Configuration;
import com.lzj.copy.mybatis.binding.MapperMethod;
import com.lzj.copy.mybatis.statement.StatementHandler;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 17:43
 * @Version 1.0
 * SimpleExecutor Mybatis三种执行器中的其中一种的实现
 */
public class SimpleExecutor implements Executor {

    private Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override //实现Executor接口 中的query方法
    public <T> T query(MapperMethod method, Object parameter) throws Exception {
        StatementHandler statementHandler = new StatementHandler(configuration);
        return statementHandler.query(method,parameter);
    }
}
