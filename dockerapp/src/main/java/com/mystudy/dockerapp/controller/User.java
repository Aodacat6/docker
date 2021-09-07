package com.mystudy.dockerapp.controller;

import java.io.Serializable;

/**
 * @author ：songdalin
 * @date ：2021-09-07 下午 08:05
 * @description：
 * @modified By：
 * @version: 1.0
 */

public class User implements Serializable {

    private String name;

    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
