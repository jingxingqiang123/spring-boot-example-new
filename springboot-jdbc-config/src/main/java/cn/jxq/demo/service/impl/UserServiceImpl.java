package cn.jxq.demo.service.impl;

import cn.jxq.demo.mapper.UserMapper;
import cn.jxq.demo.pojo.User;
import cn.jxq.demo.service.UserService;
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
