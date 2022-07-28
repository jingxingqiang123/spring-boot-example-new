package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 需要mybatis-plus版本 >= 3.0.7 param 参数名要么叫ew,要么加上注解@Param(Constants.WRAPPER) 使用${ew.customSqlSegment}
     * 不支持 Wrapper 内的entity生成where语句
     *
     * @param wrapper
     * @return
     */
    @Select("select * from sys_user ${ew.customSqlSegment}")
    List<User> getAll(@Param(Constants.WRAPPER) Wrapper wrapper);
}