package com.mystudy.dockerapp.controller;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author ：songdalin
 * @date ：2021-06-15 下午 04:37
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class ObjectSizeTest {

    public static void main(String[] args){
        T t = new T();
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
    }
}
