package jdbcandmybatis.mysqlutil.statement;

import jdbcandmybatis.mysqlutil.binding.MapperMethod;
import jdbcandmybatis.mysqlutil.result.DefaultResultSetHandler;
import jdbcandmybatis.mysqlutil.result.ResultSetHandler;
import jdbcandmybatis.mysqlutil.session.Configuration;
import jdbcandmybatis.mysqlutil.util.DbUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.SQLException;

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
