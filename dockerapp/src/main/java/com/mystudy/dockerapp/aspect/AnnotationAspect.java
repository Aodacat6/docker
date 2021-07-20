package com.mystudy.dockerapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：songdalin
 * @date ：2021-07-20 下午 06:58
 * @description：注解切面
 * @modified By：
 * @version: 1.0
 */
@Aspect
@Component
public class AnnotationAspect {

    /**
     * 注解切面
     * @param joinPoint
     * @return around 必须返回object，否则请求者收不到结果
     * @throws Throwable
     */
    @Around("@annotation(com.mystudy.dockerapp.annotation.MyAnnotation)")
    public Object myAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("this is before");

        /**
         * 代理模式，基于反射调用被代理的方法，实现proceed
         */
        //返回处理结果
        Object object = joinPoint.proceed();
        System.out.println("this is after" + object.toString());
        //返回处理结果
        return object;
    }
}
