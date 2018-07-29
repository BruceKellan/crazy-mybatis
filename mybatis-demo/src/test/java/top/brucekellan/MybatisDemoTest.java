package top.brucekellan;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import top.brucekellan.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemoTest {

    @Test
    public void domain() {
        SqlSession sqlSession = null;
        try{
            //加载核心配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //创建sqlsession工厂 -->相当于connection
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //获取sqlsession -->相当于执行sql语句对象
            sqlSession = sqlSessionFactory.openSession();
            //执行sql
            List<User> userList = sqlSession.selectList("top.brucekellan.mapper.UserMapper.listAll");
            System.out.println(userList);
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

}
