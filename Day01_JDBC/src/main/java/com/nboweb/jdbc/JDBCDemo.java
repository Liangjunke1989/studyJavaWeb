package com.nboweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JavaWeb第一天：JDBC快速入门
 */
public class JDBCDemo {
    public static void main(String[] args) throws Exception{
        //01、注册驱动
        // Class.forName("com.mysql.cj.jdbc.Driver");//新版本无需注册
        //02、获取连接u
        // String url="jdbc:mysql://127.0.0.1:3306/db1";//协议、地址、数据库名
        // String url="jdbc:mysql:///db1";//协议、数据库名
        String url="jdbc:mysql:///db1?useSSL=false";//协议、数据库名,添加参数
        String username="root";
        String password="liang521";
        Connection conn = DriverManager.getConnection(url, username, password);
        //03、定义SQL语句
        String sql="UPDATE tb_user SET password=12345 WHERE id=2;";
        //04、获取执行sql的对象Statement
        Statement stmt=conn.createStatement();//
        //05、执行sql
        int count = stmt.executeUpdate(sql);//返回受影响的行数
        //06、处理结果
        System.out.println(count);
        //07、释放资源
        stmt.close();
        conn.close();
    }
}
