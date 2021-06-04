package com.mystudy.dockerapp.controller;

import java.util.Objects;

/**
 * @author ：songdalin
 * @date ：2021-06-04 上午 09:51
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class SynchronizedTest {

    private Object lock = new Object();


    public void test () throws InterruptedException {

        System.out.println(Thread.currentThread() + "enter test()....");

        synchronized (lock) {
            System.out.println(Thread.currentThread() + "lock in....");
            Thread.sleep(100);
            System.out.println(Thread.currentThread() + "lock out....");
        }

        System.out.println(Thread.currentThread() + "out test()....");

    }
}
