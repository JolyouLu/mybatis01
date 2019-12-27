package com.lzj.copy.mybatis.binding;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 18:00
 * @Version 1.0
 * 用于Mappers注册的类
 * key是 xml中的 namespace+id+resultType
 * value是 MapperMethod对象 存放着sql：sql语句 type：返回值的class
 */
public class MapperRegistry {
    private Map<String, MapperMethod> knownMappers = new HashMap<String,MapperMethod>();

    public Map<String, MapperMethod> getKnownMappers() {
        return knownMappers;
    }

    public void setKnownMappers(Map<String, MapperMethod> knownMappers) {
        this.knownMappers = knownMappers;
    }
}
