package com.mystudy.dockerapp.se;

import com.mystudy.dockerapp.controller.StaticTest;
import com.sun.org.apache.regexp.internal.RE;

/**
 * @author ：songdalin
 * @date ：2021-08-19 下午 01:19
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class Single {

    private Single(){}

    private static class StaticSingle {

        static Single NEW_INSTANCE = new Single();
    }

    public static synchronized Single getInstance() {
        System.out.println("进入getInstance");
        return StaticSingle.NEW_INSTANCE;
    }

}
