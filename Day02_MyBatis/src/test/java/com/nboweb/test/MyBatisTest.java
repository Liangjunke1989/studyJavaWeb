package com.nboweb.test;

import com.nboweb.mapper.BrandMapper;
import com.nboweb.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {
        //1、获取SqlSessionFactory
        //System.out.println(System.getProperty("user.dir"));
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //4、执行方法
        List<Brand> brands = brandMapper.selectAll();

        System.out.println(brands);

        //5、释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        int id=1;
        //1、获取SqlSessionFactory
        //System.out.println(System.getProperty("user.dir"));
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5、释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById02() throws IOException {
        int id=1;
        //1、获取SqlSessionFactory
        //System.out.println(System.getProperty("user.dir"));
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5、释放资源
        sqlSession.close();
    }
    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status=1;
        String companyName="华为";
        String brandName="华为";

        //处理参数
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);

        //Map
        Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        //map.put("brandName",brandName);

        //1、获取SqlSessionFactory
        //System.out.println(System.getProperty("user.dir"));
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        //List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5、释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
        //接收参数
        int status=1;
        String companyName="华为";
        String brandName="华为";

        //处理参数
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";

        //封装对象
        Brand brand = new Brand();
        //brand.setStatus(status);
        //brand.setBrandName(brandName);
        //brand.setCompanyName(companyName);


        //1、获取SqlSessionFactory
        //System.out.println(System.getProperty("user.dir"));
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        //List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        //5、释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        //接收参数
        int status=1;
        String companyName="波导";
        String brandName="波导";
        String description="手机中的战斗机";
        int ordered=100;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1、获取SqlSessionFactory
        //System.out.println(System.getProperty("user.dir"));
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行方法
        brandMapper.add02(brand);
        int id = brand.getId();
        System.out.println(id);

        //5、释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //接收参数
        int status=0;
        String brandName="波导手机机11";
        String companyName="波导公司11";
        String description="手机中的战斗机11";
        int ordered=200;
        int id=6;
        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);
        brand.setId(id);

        //1、获取SqlSessionFactory
        //System.out.println(System.getProperty("user.dir"));
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行方法
        int i = brandMapper.update(brand);
        System.out.println("影响的行数为："+i);

        //5、释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        //接收参数
        int id=7;

        //封装对象
        Brand brand = new Brand();
        brand.setId(id);

        //1、获取SqlSessionFactory
        //System.out.println(System.getProperty("user.dir"));
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行方法
        brandMapper.deleteById(id);

        //5、释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        //接收参数
        int[] ids={2,3,4,5,6,7,8};

        //1、获取SqlSessionFactory
        //System.out.println(System.getProperty("user.dir"));
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行方法
       // brandMapper.deleteByIds(ids);
        brandMapper.deleteByIds02(ids);

        //5、释放资源
        sqlSession.close();
    }
}
