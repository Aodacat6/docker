package com.mystudy.dockerapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：songdalin
 * @date ：2021-06-03 下午 06:07
 * @description： 各种锁
 * @modified By：
 * @version: 1.0
 */

public class LockTest {

    public static void main(String[] args){
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new ThreadTest();
            list.add(thread);
        }
        list.forEach(thread -> {
            thread.start();
        });
    }
}

class ThreadTest extends Thread{

    private int i;

/*    private static int lock() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            i++;
            return i;
        }finally {
            lock.unlock();
        }
    }*/

    @Override
    public   void run() {
/*        Lock lock = new ReentrantLock();
        if(lock.tryLock()) {
            try {
                i++;
                System.out.println(Thread.currentThread() + "   i:"+i);
            } finally {
                lock.unlock();
            }
        }else {
        }*/
        //公平锁
        Lock lock = new ReentrantLock(true);
        lock.lock();
        try {
            i++;
            System.out.println(Thread.currentThread() + "   i:"+i);
        }finally {
            lock.unlock();
        }
    }
}
