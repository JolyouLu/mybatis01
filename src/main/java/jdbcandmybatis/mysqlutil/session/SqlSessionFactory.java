package jdbcandmybatis.mysqlutil.session;

import jdbcandmybatis.mysqlutil.executor.SimpleExecutor;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 21:13
 * @Version 1.0
 */
public class SqlSessionFactory {

    public SqlSession openSession(Configuration configuration){
        return new DefaultSqlSession(configuration,new SimpleExecutor(configuration));
    }
}
