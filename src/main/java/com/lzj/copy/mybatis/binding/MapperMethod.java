package com.lzj.copy.mybatis.binding;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 21:07
 * @Version 1.0
 * 用于存放sql语句和返回值类型的类
 */
public class MapperMethod<T> {
    //sql语句
    private String sql;
    //返回的类
    private Class<T> type;

    public MapperMethod() {
    }

    public MapperMethod(String sql, Class<T> type) {
        this.sql = sql;
        this.type = type;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }
}
