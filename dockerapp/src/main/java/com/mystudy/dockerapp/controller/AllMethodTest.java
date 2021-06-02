package com.mystudy.dockerapp.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：songdalin
 * @date ：2021-06-02 下午 09:58
 * @description：杂七杂八测试
 * @modified By：
 * @version: 1.0
 */
public class AllMethodTest {

    public static void main(String[] args){
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("6");
        list2.add("7");
        //取交集
        list1.retainAll(list2);

        list1.forEach(System.out::println);

    }
}

