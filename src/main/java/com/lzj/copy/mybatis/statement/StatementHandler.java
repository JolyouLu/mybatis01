package com.lzj.copy.mybatis.statement;

import com.lzj.copy.mybatis.binding.MapperMethod;
import com.lzj.copy.mybatis.result.DefaultResultSetHandler;
import com.lzj.copy.mybatis.session.Configuration;
import com.lzj.copy.mybatis.util.DbUtil;

import java.sql.Connection;


import java.sql.PreparedStatement;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 22:00
 * @Version 1.0
 */
public class StatementHandler {
    private Configuration configuration;

    private DefaultResultSetHandler resultSetHandler;

    public StatementHandler() {
    }

    public StatementHandler(Configuration configuration) {
        this.configuration = configuration;
        resultSetHandler = new DefaultResultSetHandler();
    }

    public <T> T query(MapperMethod method, Object parameter) throws Exception {
        Connection connection = DbUtil.open();
        PreparedStatement preparedStatement = connection.prepareStatement(String.format(method.getSql(), Integer.parseInt(String.valueOf(parameter))));
        preparedStatement.execute();
        return resultSetHandler.handle(preparedStatement,method);
    }

}
