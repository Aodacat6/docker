package com.mystudy.dockerapp.controller;

/**
 * @author ：songdalin
 * @date ：2021-06-03 下午 06:33
 * @description：内存可见性
 * @modified By：
 * @version: 1.0
 */
public class MemorySee {

    private static int a;

    public static void main(String[] args){
        MemorySee see1 = new MemorySee();
        MemorySee.a = 1;


    }
}
