package jdbcandmybatis.mysqlutil.session;

import jdbcandmybatis.mysqlutil.binding.MapperMethod;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 17:39
 * @Version 1.0
 */
public interface SqlSession {
    <T> T selectOne(MapperMethod mapperMethod, Object statement) throws Exception;
}
