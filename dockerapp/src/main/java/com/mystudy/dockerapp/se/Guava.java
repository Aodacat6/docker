package com.mystudy.dockerapp.se;

import javax.validation.constraints.NotNull;

/**
 * @author ：songdalin
 * @date ：2021-07-22 下午 05:25
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class Guava {

    public static void main(String[] args){

        testNotNull(null);
    }

    private static Integer testNotNull(@NotNull(message = "not null ~~") Integer a) {
        return a;
    }
}

