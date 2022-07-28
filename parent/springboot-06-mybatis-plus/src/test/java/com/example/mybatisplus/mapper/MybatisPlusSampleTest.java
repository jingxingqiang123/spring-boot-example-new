package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.example.mybatisplus.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@MybatisPlusTest
@Slf4j
class MybatisPlusSampleTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect1() {
        log.info(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelect12() {
        log.info(("----- selectAll method test ------"));
        LambdaQueryWrapper<User> lambdaWrapper = new LambdaQueryWrapper();
        User user = new User();
        user.setId(5L);
        lambdaWrapper.eq(user.getId() == null, User::getId, user.getId());
        List<User> userList = userMapper.getAll(lambdaWrapper);
        // 过滤条件失败，变成查询所有字段
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);

        LambdaQueryWrapper<User> lambdaWrapper2 = new LambdaQueryWrapper();
        User user1 = new User();
        user1.setId(5L);
        lambdaWrapper.eq(user1.getId() != null, User::getId, user.getId());
        List<User> userList1= userMapper.getAll(lambdaWrapper);
        Assert.assertEquals(1, userList1.size());
        userList.forEach(System.out::println);
    }
}