package jdbcandmybatis.mysqlutil.result;

import jdbcandmybatis.mysqlutil.binding.MapperMethod;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 22:49
 * @Version 1.0
 */
public interface ResultSetHandler {
    public <T> T handle(PreparedStatement pstmt, MapperMethod mapperMethod) throws Exception;
}
