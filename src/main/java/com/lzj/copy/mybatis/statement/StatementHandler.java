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
 * 真正查询数据库的类
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
    //查询结果
    public <T> T query(MapperMethod method, Object parameter) throws Exception {
        //使用工具类打开数据库连接
        Connection connection = DbUtil.open();
        //传入sql 和 值
        PreparedStatement preparedStatement = connection.prepareStatement(String.format(method.getSql(), Integer.parseInt(String.valueOf(parameter))));
        //执行执行器
        preparedStatement.execute();
        //把结果映射到对象中
        return resultSetHandler.handle(preparedStatement,method);
    }

}
