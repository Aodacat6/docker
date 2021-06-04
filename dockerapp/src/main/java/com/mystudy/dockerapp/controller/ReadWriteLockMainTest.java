package com.mystudy.dockerapp.controller;

import java.util.Random;

/**
 * @author ：songdalin
 * @date ：2021-06-04 上午 09:35
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class ReadWriteLockMainTest {

    public static void main(String[] args){
        ReadWriteLockTest test = new ReadWriteLockTest();

        for (int i = 0; i < 3; i++) {

            /**
             * 读进程
             */
            new Thread(){
                @Override
                public void run() {
                    while (true) {
                        test.get();
                    }
                }
            }.start();

            /**
             * 写进程
             */
            new Thread(){
                @Override
                public void run() {
                    while (true) {
                        test.set(new Random().nextInt());
                    }
                }
            }.start();
        }
    }
}
