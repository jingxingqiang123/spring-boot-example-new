package com.study.sringbootperfectweb.service;

import com.study.sringbootperfectweb.pojo.User;

/**
 * Created by jingxingqiang on 2020/4/10 21:16
 */
public interface UserService {
    /**
     *
     * @param user 用户对象
     * @return 成功则返回"success"，失败则返回错误信息
     */
    String addUser(User user);
}
