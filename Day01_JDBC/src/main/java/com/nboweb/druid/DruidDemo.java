package com.nboweb.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid数据库连接池演示
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1、导入jar包
        //2、定义配置文件
        //3、加载配置文件
        //4、获取连接池对象
        Properties prop = new Properties();//

        // 使用类路径加载配置文件，更加稳定
        InputStream inputStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(inputStream);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5、获取数据库连接Connection
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        System.out.printf("connection:%s", connection);
        //打印连接状态
        if (connection != null){
            System.out.println("连接成功！");
        }else {
            System.out.println("连接失败！");
        }
        // 关闭连接
        if (connection != null) {
            connection.close();
        }
        System.out.println("关闭连接！");
    }
}

