package com.mystudy.dockerapp.se;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：songdalin
 * @date ：2021-09-29 下午 02:25
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class StringT {

    public static void main(String[] args){
        String dd = "ddd";
        StringT.test(dd);
        //System.out.println(dd);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next.equals(2)) {
                iterator.remove();
                continue;
            }
            System.out.println(next);
        }
        //list.forEach(System.out::println);
    }

    public static void test(String tt) {
        tt = tt + "222";
        //tt.
    }



}


