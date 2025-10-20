package com.nboweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo02_DriverManager {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //3.获取连接
        String url = "jdbc:mysql://localhost:3306/db1";
        String user = "root";
        String password = "liang521";
        Connection conn = DriverManager.getConnection(url, user, password);
        //4.获取数据库操作对象
        Statement stmt = conn.createStatement();
        //5.执行sql
        String sql = "update tb_user set password=101010 where id=1";
        int count = stmt.executeUpdate(sql);
        //6.处理结果
        System.out.println(count);
        //7.释放资源
        stmt.close();
        conn.close();
        System.out.println("修改完毕");

    }
}
