package cn.speed.demo.jdbc.service.impl;

import cn.speed.demo.jdbc.mapper.UserMapper;
import cn.speed.demo.jdbc.pojo.User;
import cn.speed.demo.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jingxingqiang on 2019/12/2 23:27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(long id) {
        return this.userMapper.selectByPrimaryKey(id);

    }
    @Transactional
    public void deleteById(Long id){
        this.userMapper.deleteByPrimaryKey(id);
    }
    @Override
    public List<User> queryAll() {
        return this.userMapper.selectAll();
    }
}
