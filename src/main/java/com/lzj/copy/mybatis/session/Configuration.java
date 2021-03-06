package com.lzj.copy.mybatis.session;

import com.lzj.copy.mybatis.binding.MapperMethod;
import com.lzj.copy.mybatis.binding.MapperRegistry;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 16:51
 * @Version 1.0
 * Configuration 用于读取mybatis的配置文件 并且加载到内存中
 */
public class Configuration {
    private InputStream inputStream;
    //new一个MapperRegistry 把从Configuration加载的mapper添加到MapperRegistry中
    MapperRegistry mapperRegistry = new MapperRegistry();

    /*通过Dom4j读取配置文件信息*/
    public void loadConfigurations() throws IOException{
        try {
            //读取文件转成dom
            Document document = new SAXReader().read(inputStream);
            //获取根标签
            Element root = document.getRootElement();
            //获取根标签下的mappers中的mapper 返回list
            List<Element> mappers = root.element("mappers").elements("mapper");
            //遍历遍历这些mapper
            for (Element mapper : mappers) {
                //遍历mapper获取如果属性名为resource获取其中的值
                if (mapper.attribute("resource")!=null){
                    mapperRegistry.setKnownMappers(loadXMLConfiguration(mapper.attribute("resource").getText()));
                }
                //遍历mapper获取如果属性名为class获取其中的值
                if (mapper.attribute("class") != null){
                }
            }
        }catch (Exception e){
            System.out.println("读取配置文件错误！");
        }finally {
            inputStream.close();
        }
    }

    /*通过dom4j读取mapper.xml中的信息*/
    private Map<String, MapperMethod> loadXMLConfiguration(String resource) throws DocumentException, IOException {
        Map<String,MapperMethod> map = new HashMap<>();
        InputStream is =null;
        try {
            is = this.getClass().getClassLoader().getResourceAsStream(resource);
            Document document = new SAXReader().read(is);
            Element root = document.getRootElement();
            if (root.getName().equalsIgnoreCase("mapper")){
                //获取namespace中的值
                String namespace = root.attribute("namespace").getText();
                //遍历获取xml下的全部 sql和返回值类型 put到map中
                for (Element select:(List<Element>) root.elements("select")){
                    MapperMethod mapperMethod = new MapperMethod();
                    //获取sql语句
                    mapperMethod.setSql(select.getText().trim());
                    //获取返回值类型
                    mapperMethod.setType(Class.forName(select.attribute("resultType").getText()));
                    //namespace+id+mapperMethod 存入到map中一级缓存的时候 如果有重复的namespace+id+mapperMethod的sql语句不访问数据库直接返回参数
                    map.put(namespace+"."+select.attribute("id").getText(),mapperMethod);
                }
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            is.close();
        }
        return map;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public MapperRegistry getMapperRegistry() {
        return mapperRegistry;
    }

    public void setMapperRegistry(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }
}
