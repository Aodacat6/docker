package com.mystudy.dockerapp.se;

import lombok.SneakyThrows;

/**
 * @author ：songdalin
 * @date ：2021-10-29 下午 02:01
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Chlid chlid = new Chlid();
        chlid.start();
        //join  加入另一个线程，等该线程执行完另一个线程才能执行
        //join 执行完后，使用 this.notifyAll() 通知所有线程，如果主线程能获取执行锁，则执行
        chlid.join();
        System.out.println("main is over");
    }
}

class Chlid extends Thread {

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("child run .....");
        Thread.sleep(1000);
        System.out.println("child over .....");
    }
}