package com.mystudy.dockerapp.annotation;

import java.lang.annotation.*;

/**
 * @author ：songdalin
 * @date ：2021-07-20 下午 06:56
 * @description：标记用annotation
 * @modified By：
 * @version: 1.0
 */

/**
 * 1、RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
 * 2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
 * 3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
 */


@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
    String name();
}
