package com.mystudy.dockerapp.centeracdm;

/**
 * @author ：songdalin
 * @date ：2021-06-18 上午 10:32
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class StringTest {

    /**
     * string 相关解析
     */
    public static void main(String[] args){
        /**
         * string是不可变对象，每次操作会生成新对象，将引用指向新对象，而不是对就对象的操作
         */
        String a = "a";
        a = a + "b";

        //实例
        a.concat("b");


        /**
         * stringbuliser  和  stringbuffer
         */
        StringBuilder sb = new StringBuilder();
        sb.append("3");

        /**
         * stringbuffer 线程安全
         */

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("d");

    }
}
