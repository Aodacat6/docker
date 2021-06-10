package com.mystudy.dockerapp.controller;

/**
 * @author ：songdalin
 * @date ：2021-06-09 下午 05:51
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class StaticMainTest {

    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
/*
            new Thread(){
                @Override
                public void run () {*/
                    StaticTest test1 = new StaticTest();
                    test1.set("ww1");
/*                }

            }.start();*/

        }
        StaticTest test = new StaticTest();
        System.out.println(test.get());
    }
}
