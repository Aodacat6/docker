package com.mystudy.dockerapp;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.*;

/**
 * @author ：songdalin
 * @date ：2021-12-28 上午 10:16
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class OtherTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        System.out.println(delSomeStr("sdfsdfdfdf", ","));

 /*       final Class clazz = Class.forName("com.mystudy.dockerapp.Student");
        Object object = clazz.newInstance();*/

        //student.getName();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 10,
                TimeUnit.HOURS, new LinkedBlockingDeque<>(), new NamedThreadFactory("my-"));

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "...");
                try {
                    Thread.sleep(1000* 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }

    }

/*    public static String delSomeStr(String str, String c) {
        final String[] split = str.split(c);
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(s);
        }
        return sb.toString();
    }*/
}

@Getter
@Setter
class Student {

    private String name;

    public Student() {

        System.out.println("gouzao zhix .................");

    }
}