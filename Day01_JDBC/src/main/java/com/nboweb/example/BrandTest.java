package com.nboweb.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.nboweb.pojo.Brand;
import org.junit.Test;


import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 品牌数据的增删改查操作
 */
public class BrandTest {
    /**
     * 查询所有
     * 1、SQL: select * from tb_brand
     * 2、参数：
     * 3、结果：List<Brand>
     */
    @Test
    public void testSelectAll() throws Exception {
        //1、获取Connection
        //01、加载配置文件
        //System.out.println(System.getProperty("user.dir"));
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/druid.properties"));
        //02、获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //03、获取数据库连接Connection
        Connection conn = dataSource.getConnection();

        //2、定义SQL
        String sql = "select * from tb_brand";

        //3、获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4、设置参数

        //5、执行sql
        ResultSet rs = pstmt.executeQuery(sql);

        //6、处理结果 List<Brand> 封装为Brand对象，封装List集合
        Brand brand = null;
        List<Brand> brands=new ArrayList<Brand>();
        while (rs.next()) {
            //01、获取数据
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            //02、封装Brand对象
            brand=new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setDescription(description);
            brand.setOrdered(ordered);
            brand.setStatus(status);

            //装载集合
            brands.add(brand);
        }
        System.out.println(brands);
        //7、释放资源
        rs.close();
        pstmt.close();
        conn.close();

    }
}
