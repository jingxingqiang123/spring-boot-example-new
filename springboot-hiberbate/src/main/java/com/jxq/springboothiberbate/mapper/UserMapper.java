package com.jxq.springboothiberbate.mapper;

import com.jxq.springboothiberbate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by jingxingqiang on 2019/11/27 22:13
 */
@Repository
public interface UserMapper extends JpaRepository<User,Integer> {


    public User save(User user);

    /**
     *
     * HQL的写法：通过@Query注解，完成了HQL的书写，其中“:name”与下方的@Param注解中参数保持一致。
     * 注意：在HQL中的表名应该是ORM映射的类名，而且HQL与传统的SQL语句有一些出入，比如“*”的意义不尽相同等等
     * @Query(value = "select u from User u WHERE name=:name")
     */
    @Query(value = "SELECT * FROM yyh_user WHERE name=?", nativeQuery = true)
    public User findByName(@Param("name") String name);
}
