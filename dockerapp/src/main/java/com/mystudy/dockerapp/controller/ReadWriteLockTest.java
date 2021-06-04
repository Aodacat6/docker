package com.mystudy.dockerapp.controller;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ：songdalin
 * @date ：2021-06-04 上午 09:26
 * @description：读写锁
 * @modified By：
 * @version: 1.0
 */
public class ReadWriteLockTest {

    /**
     * 读锁可以多个线程同时获取
     * 写锁只能一个
     */
    private int a = 0;

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public void get() {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread() + "get ：" + a);
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void set(int a) {
        readWriteLock.writeLock().lock();
        try {
            this.a = a;
            System.out.println(Thread.currentThread() + "set : " + a);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

}
