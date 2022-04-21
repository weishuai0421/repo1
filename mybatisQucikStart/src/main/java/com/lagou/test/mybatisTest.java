package com.lagou.test;

import com.lagou.mapper.UserMapper;
import com.lagou.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {

    @Test
    public void mybatisQuickStart() throws IOException {

        //1.加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //2. 获取sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //3. 获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4. 执行sql 参数：statementid : namespace.id
        List<User> users = sqlSession.selectList("userMapper.findAll");

        //5. 遍历打印结果
        for (User user : users) {
            System.out.println(user);
        }

        //6. 关闭资源
        sqlSession.close();

    }


    @Test
    public void test1() throws IOException {

        //1.加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //2. 获取sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //3. 获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }


        //6. 关闭资源
        sqlSession.close();

    }

}
