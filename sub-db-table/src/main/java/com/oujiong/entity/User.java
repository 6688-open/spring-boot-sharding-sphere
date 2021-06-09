package com.oujiong.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * user表
 */
@Data
@AllArgsConstructor
@Builder
public class User {
    /**
     * 主键
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     * 是否删除 1删除 0未删除
     */
    private Integer status;
    /**
     * 运单信息
     */
    private String wbNo;


    public User(Long id, String name, String sex, Integer age, String wbNo) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.wbNo = wbNo;
    }
}