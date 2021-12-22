package com.mystudy.dockerapp.se;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author ：songdalin
 * @date ：2021-08-26 下午 08:40
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class ThreadExecuterTest {


    /**
     *
     * 线程池学习
     *
     *  线程池创建初始线程数为0， 每次创建都加1， 而不是直接创建coresize
     *
     * @param args
     */

    public static void main(String[] args){
/*        int core = 5;
        int max = 10;
        long keepAliveTime = 10;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
        ThreadFactory threadFactory = new ThreadFactoryBuilder().build();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(core,
                max, keepAliveTime, timeUnit, workQueue, threadFactory, handler);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  ....");
            });
        }

        //executor.shutdown();
        executor.shutdownNow();*/

        ExecutorService executorService = Executors.newSingleThreadExecutor();

    }
}
