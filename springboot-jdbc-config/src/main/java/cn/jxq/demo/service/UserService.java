package cn.jxq.demo.service;


import cn.jxq.demo.pojo.User;

import java.util.List;

public interface UserService {
    User queryById(long l);

    List<User> queryAll();
}
