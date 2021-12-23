package com.mystudy.dockerapp.future;

import java.util.concurrent.*;

/**
 * @author ：songdalin
 * @date ：2021-12-23 下午 01:30
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class FutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);

   /*     for (int i = 0; i < 10; i++) {
            executorService.execute(
                    () -> new Thing().run());
        }*/
        Future<String> future = executorService.submit(() -> {
            String s =  "5";
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s;
        });

        Future<String> future2 = executorService.submit(() -> {
            String s =  "4";
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s;
        });

        System.out.println("111");
        while (!future.isDone() || !future2.isDone()) {
            System.out.println("thread is doing....");
            Thread.sleep(200);
        }
        final String s = future.get();
        final String s1 = future2.get();
        System.out.println("future out  " + s + "future2 out " + s1);
        System.out.println("222");

    }


}

class Thing implements Runnable {


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  hello");

    }
}

class MyThread extends Thread {

}