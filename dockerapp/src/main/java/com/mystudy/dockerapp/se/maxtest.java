package com.mystudy.dockerapp.se;

import javax.validation.constraints.NotNull;

/**
 * @author ：songdalin
 * @date ：2021-09-09 下午 01:26
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class maxtest {

    public static void main(String[] args){
        double[] arr = {10.3, 2.3,5.6,8,1,0};
        System.out.println("max:  " + getMaxInArr(arr));
        System.out.println("min:  " + getMinInArr(arr));
    }

    private static double getMaxInArr(@NotNull double[] arr) {
        double tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > tmp) {
                tmp = arr[i];
            }
        }
        return tmp;
    }

    private static double getMinInArr(@NotNull double[] arr) {
        double tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < tmp) {
                tmp = arr[i];
            }
        }
        return tmp;
    }


}
