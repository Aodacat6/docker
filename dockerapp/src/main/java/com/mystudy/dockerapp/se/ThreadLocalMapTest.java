package com.mystudy.dockerapp.se;

/**
 * @author ：songdalin
 * @date ：2021-08-29 下午 06:20
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class ThreadLocalMapTest {


    private static ThreadLocal<String> threadLocal = new ThreadLocal();

    private static ThreadLocal<String> threadLocal1 = new ThreadLocal();


    public static void main(String[] args){
        threadLocal.set("sss");
        //threadLocal.get();
        //threadLocal.remove();
        threadLocal1.get();
    }
}
