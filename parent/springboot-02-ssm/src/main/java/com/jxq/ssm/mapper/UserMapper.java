package com.jxq.ssm.mapper;

import com.jxq.ssm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();

    User checkByUP(@Param("username") String username,
                   @Param("password") String password);

    String findUserNameByUserName(String username);

    int insertUserInfo(User user);
}
