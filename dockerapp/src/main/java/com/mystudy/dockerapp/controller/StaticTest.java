package com.mystudy.dockerapp.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：songdalin
 * @date ：2021-06-09 下午 05:50
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class StaticTest {

    static List<String> list = new ArrayList<>();

    public void set(String str) {
        list.add(str);
    }

    public String get() {
        String str = "";
        for (String s : list) {
            str = str + s;
        }
        return str;
    }
}
