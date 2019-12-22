package jdbcandmybatis.mysqlutil.executor;

import jdbcandmybatis.mysqlutil.binding.MapperMethod;
import jdbcandmybatis.mysqlutil.session.Configuration;
import jdbcandmybatis.mysqlutil.statement.StatementHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

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

    @Override
    public <T> T query(MapperMethod method, Object parameter) throws Exception {
        StatementHandler statementHandler = new StatementHandler(configuration);
        return statementHandler.query(method,parameter);
    }
}
