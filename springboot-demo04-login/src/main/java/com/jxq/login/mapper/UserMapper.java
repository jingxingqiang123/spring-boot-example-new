package com.jxq.login.mapper;

import com.jxq.login.pojo.User;
import org.apache.ibatis.annotations.Param;


/**
 * Created by jingxingqiang on 2019/7/21 20:59
 */

public interface UserMapper {


    User checkByUP(@Param("username") String username,
                   @Param("password") String password);

    String findUserNameByUserName(String username);

    int insertUserInfo(User user);
}
