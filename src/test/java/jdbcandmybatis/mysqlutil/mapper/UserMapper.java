package jdbcandmybatis.mysqlutil.mapper;


import com.lzj.jdbcandmybatis.mybatis.pojo.User;

import javax.jws.soap.SOAPBinding;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 22:41
 * @Version 1.0
 */
public interface UserMapper {
    public User getUser(Integer id);
}
