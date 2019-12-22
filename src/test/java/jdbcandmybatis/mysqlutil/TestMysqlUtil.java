package jdbcandmybatis.mysqlutil;

import jdbcandmybatis.mysqlutil.mapper.UserMapper;
import com.lzj.jdbcandmybatis.mybatis.pojo.User ;
import jdbcandmybatis.mysqlutil.session.Configuration;
import jdbcandmybatis.mysqlutil.session.DefaultSqlSession;
import jdbcandmybatis.mysqlutil.session.SqlSessionFactory;
import jdbcandmybatis.mysqlutil.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: LZJ
 * @Date: 2019/12/22 22:36
 * @Version 1.0
 */
public class TestMysqlUtil {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = TestMysqlUtil.class.getClassLoader().getResourceAsStream("myconfig.xml");
        Configuration configuration = new Configuration();
        configuration.setInputStream(inputStream);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        DefaultSqlSession sqlSession = (DefaultSqlSession) sqlSessionFactory.openSession(configuration);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUser(1);
        System.out.println(user);
    }
}
