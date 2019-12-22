package jdbcandmybatis.mysqlutil.result;

import jdbcandmybatis.mysqlutil.binding.MapperMethod;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 22:13
 * @Version 1.0
 * 拿到结果 然后进行放射赋值
 */
public class DefaultResultSetHandler implements ResultSetHandler{
    public <T> T handle(PreparedStatement pstmt, MapperMethod mapperMethod) throws Exception {
        Object resultObj = new DefaultObjectFactory().create(mapperMethod.getType());
        ResultSet rs = pstmt.getResultSet();
        if (rs.next()){
            int i = 0;
            for (Field filed : resultObj.getClass().getDeclaredFields()){
                setValue(resultObj,filed,rs,i);
            }
        }
        return (T) resultObj;
    }

    private void setValue(Object resultObj,Field field,ResultSet rs,int i) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {
        Method setMethod = resultObj.getClass().getMethod("set" + upperCapital(field.getName()), field.getType());
        setMethod.invoke(resultObj,getResult(field,rs));
    }

    private String upperCapital(String name){
        String first = name.substring(0,1);
        String tail = name.substring(1);
        return first.toUpperCase()+tail;
    }

    private Object getResult(Field field,ResultSet rs) throws SQLException {
        Class<?> type = field.getType();
        if (Integer.class==type){
            return rs.getInt(field.getName());
        }
        if (String.class==type){
            return rs.getString(field.getName());
        }
        return rs.getString(field.getName());
    }
}
