package com.mystudy.dockerapp.controller;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：songdalin
 * @date ：2021-06-03 下午 07:28
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class AllTest {

    public static void main(String[] args){
//        String str = null;
//        switch (str) {
//            case "111" :
//                System.out.println(11);
//                break;
//            default:
//                System.out.println("default");
//        }

        List<String> list = new ArrayList<>();
        list.add("ddd");
        list.add(null);

        System.out.println(list);

        list = list.stream().filter(l -> Objects.nonNull(l)).collect(Collectors.toList());
        System.out.println(list);

    }
}
