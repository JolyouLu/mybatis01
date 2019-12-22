package jdbcandmybatis.mysqlutil.pojo;

import java.io.Serializable;

/**
 * @Author: LZJ
 * @Date: 2019/12/21 13:54
 * @Version 1.0
 */
public class User implements Serializable {

    private Integer id;
    private String username;
    private Integer age;
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
