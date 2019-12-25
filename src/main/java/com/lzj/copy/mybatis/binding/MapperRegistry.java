package com.lzj.copy.mybatis.binding;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 18:00
 * @Version 1.0
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
