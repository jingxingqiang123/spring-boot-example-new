package com.example.mybatisplus.mapper;

import com.example.mybatisplus.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * UserNapperTest
 *
 * @author: admin
 * @create: 2022/07/24 10:25
 */

//@RunWith(SpringRunner.class) // org.junit.jupiter.api.Test; 不用加此注解
@SpringBootTest
@Slf4j
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        log.info(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
