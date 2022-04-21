package com.lagou.mapper;

import com.lagou.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {


      //查询用户
    @Select("select * from user" )
    public List<User> findAll();
}
