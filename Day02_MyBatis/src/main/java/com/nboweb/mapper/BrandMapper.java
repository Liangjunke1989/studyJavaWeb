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

    //    /**
//     * 查询：条件查询
//     *  *参数接收：
//     *      1、散装参数
//     *          如果方法中有多个参数，需要使用@Param("SQL参数占位符名称")类型
//     *      2、对象参数
//     *          对象属性的名称要和参数占位符名称一致
//     *      3、Map集合参数
//     * @param status 状态
//     * @param companyName 公司名称
//     * @param brandName 商品名称
//     * @return 商品对象
//     */
       // List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String brandName);
      // List<Brand> selectByCondition(Brand brand);
    /** 单条件动态查询
     *
     * @param map map类型
     * @return brand商品类
     */
    List<Brand> selectByCondition(Map map);
    List<Brand> selectByConditionSingle(Brand brand);

    /** 添加
     *
     */
    void add01(Brand brand);
    void add02(Brand brand);
    /** 修改
     *
     */
    int update(Brand brand);

    /** 根据Id删除
     *
     */
    void deleteById(int id);

    /**
     * 批量删除
     */
    void deleteByIds(@Param("ids") int[] ids);

    void deleteByIds02(int[] ids);
}
