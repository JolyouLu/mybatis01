package jdbcandmybatis.mysqlutil.executor;

import jdbcandmybatis.mysqlutil.binding.MapperMethod;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 16:52
 * @Version 1.0
 * 执行器接口
 */
public interface Executor {
    <T> T query(MapperMethod method, Object parameter) throws Exception;
}
