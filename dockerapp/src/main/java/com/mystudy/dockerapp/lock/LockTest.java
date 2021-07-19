package com.mystudy.dockerapp.lock;

import java.util.concurrent.locks.Lock;

/**
 * @author ：songdalin
 * @date ：2021-07-15 下午 02:39
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class LockTest {

    private int count = 0;

    private Object lock;

    public static void main(String[] args){
        LockTest lockTest = new LockTest();

        new Thread(() -> {
            while (true) {
                System.out.println("111");
            }
        }).start();

        

    }




}


