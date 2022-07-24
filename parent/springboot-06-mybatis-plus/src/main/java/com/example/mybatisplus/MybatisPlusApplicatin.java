package com.example.mybatisplus;

import com.example.mybatisplus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MybatisPlusApplicatin
 *
 * @author: admin
 * @create: 2022/07/24 10:21
 */
@SpringBootApplication
@MapperScan("com.example.mybatisplus.mapper")
public class MybatisPlusApplicatin {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplicatin.class);
    }
}
