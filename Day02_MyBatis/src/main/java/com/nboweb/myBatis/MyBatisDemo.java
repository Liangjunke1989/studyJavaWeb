package com.nboweb.myBatis;

import com.nboweb.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * MyBatis 快速入门代码
 */

public class MyBatisDemo {
    public static void main(String[] args) throws IOException {
        //1、加载mybatis 的核心配置文件，获取SqlSessionFactory对象
        System.out.println(System.getProperty("user.dir"));
        String resource = "Day02_MyBatis/src/main/resources/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3、执行sql语句
        List<User> users = sqlSession.selectList("testLJK.selectAll");
        System.out.println(users);

        //4、释放资源
        sqlSession.close();

    }
}
