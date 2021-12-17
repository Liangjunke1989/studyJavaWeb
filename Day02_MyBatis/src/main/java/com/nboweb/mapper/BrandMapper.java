package com.nboweb.mapper;

import com.nboweb.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**
     * 查询：查询所有
     */
    List<Brand> selectAll();
    /**
     * 查询：查询详情
     */
    Brand selectById(int id);

    /**
     * 查询：条件查询
     *  *参数接收：
     *      1、散装参数
     *          如果方法中有多个参数，需要使用@Param("SQL参数占位符名称")类型
     *      2、对象参数
     *          对象属性的名称要和参数占位符名称一致
     *      3、Map集合参数
     * @param status 状态
     * @param companyName 公司名称
     * @param brandName 商品名称
     * @return 商品对象
     */
       // List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String brandName);
      // List<Brand> selectByCondition(Brand brand);
       List<Brand> selectByCondition(Map map);

}
