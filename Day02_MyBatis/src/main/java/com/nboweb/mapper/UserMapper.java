package com.nboweb.mapper;
import com.nboweb.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    User selectById(int id);

    //使用注解开发
    @Select("select * from tb_user where id=#{id}")
    User selectById02(int id);
}
