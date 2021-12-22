package com.mystudy.dockerapp.se;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：songdalin
 * @date ：2021-10-11 下午 09:36
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class CallableAndFuture {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("dd");
        list.add("aa");
        list.add(1, "bb");
        list.forEach(System.out::println);
    }
}
