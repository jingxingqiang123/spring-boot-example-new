package com.example.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * User
 *
 * @author: admin
 * @create: 2022/07/24 10:16
 */
@Data
@TableName("sys_user") // 表名注解，标识实体类对应的表
public class User {
    // 描述：主键注解
    // 使用位置：实体类主键字段
    @TableId
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
