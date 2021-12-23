package com.mystudy.dockerapp.future;

import io.netty.util.concurrent.CompleteFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：songdalin
 * @date ：2021-12-23 下午 02:48
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletableFuture<String> completeFuture = CompletableFuture.supplyAsync(() -> "5", executorService);
        CompletableFuture<String> completeFuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "5";
            }, executorService);


        CompletableFuture.allOf(completeFuture).join();
        CompletableFuture.allOf(completeFuture2).join();



        final String s = completeFuture.get();
        final String s2 = completeFuture2.get();



        System.out.println(s);
        System.out.println(s2);


    }


}
