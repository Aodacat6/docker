package com.mystudy.dockerapp.controller;

/**
 * @author ：songdalin
 * @date ：2021-06-04 上午 10:38
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class SynchronizedMainTest {

    public static void main(String[] args){
        SynchronizedTest test = new SynchronizedTest();

        for (int i = 0; i < 3; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        test.test();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        }
    }
}
