package com.nboweb.mapper;
import com.nboweb.pojo.User;
import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    User selectById(int id);
}
