package com.mystudy.dockerapp.se;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：songdalin
 * @date ：2021-07-23 下午 02:46
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class Collection {

    /**
     * 左右移运算
     */
    private static void zuoyouyiyunsuan() {
        int a = 30;
        /**
         * 左移   <<  数据的一倍
         * 右移   >>  数据的一半
         *
         */
        System.out.println(a >> 1);
    }

    public static void main(String[] args){
        //zuoyouyiyunsuan();
        arrayList();

    }

    private static void arrayList() {
        List<String> list = new ArrayList<>();
        System.out.println("初始长度： " + list.size());
        list.add("s");
        /**
         * 这里list.size()是list中元素的个数，不是list真实的长度
         *
         * 真实的长度是 elementData.length
         */
        System.out.println("只有1个元素时list长度： " + list.size());
        list.add("s");
        System.out.println("只有2个元素时list长度： " + list.size());
        list.add("s");
        System.out.println("只有3个元素时list长度： " + list.size());
        list.add("s");
        System.out.println("只有4个元素时list长度： " + list.size());
        list.add("s");
        System.out.println("只有5个元素时list长度： " + list.size());
    }


}
