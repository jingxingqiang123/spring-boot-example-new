package cn.speed.demo.jdbc.service;


import cn.speed.demo.jdbc.pojo.User;

import java.util.List;

public interface UserService {
    User queryById(long l);

    List<User> queryAll();
}
