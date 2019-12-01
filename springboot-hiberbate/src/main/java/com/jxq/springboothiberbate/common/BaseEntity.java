package com.jxq.springboothiberbate.common;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jingxingqiang on 2019/11/27 22:00@MappedSuperclass
 * 标识基类，这个基类不会以一个实体记录的形式映射到数据库中，
 * 但继承它的子类在映射数据库的时候会自动扫描该基类实体的映射属性，
 * 不论是自动建表、添加记录、查询等操作，都可以虽子类中的属性一同映射到数据库中
 *
 *
 * 1.@MappedSuperclass注解使用在一个实体类父类上，来标识这个父类。
 *
 * 2.@MappedSuperclass标识的类表示其不能映射到数据库表，因为其不是一个完整的实体类，
 *   但它所拥有的属性能够映射到其子类所在的表中。
 *
 * 3.@MappedSuperclass标识的类不能再有@Entity和@Table注解。
 *
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    protected Long id;

    @Column(name ="name")
    protected String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
