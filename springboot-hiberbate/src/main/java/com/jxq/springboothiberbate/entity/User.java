package com.jxq.springboothiberbate.entity;

import com.jxq.springboothiberbate.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by jingxingqiang on 2019/11/27 22:07
 * @Entity标识一个实体类，任何Hibernate映射对象都要有这个注解。
 */
@Entity
@Table(name = "yyh_user")
public class User extends BaseEntity {

}
