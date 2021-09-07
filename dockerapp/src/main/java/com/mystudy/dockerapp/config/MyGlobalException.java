package com.mystudy.dockerapp.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：songdalin
 * @date ：2021-09-07 下午 09:25
 * @description：
 * @modified By：
 * @version: 1.0
 */
@ControllerAdvice
@ResponseBody
public class MyGlobalException {

    @ExceptionHandler(Exception.class)
    public String myException(Exception e) {
        return e.toString();
    }
}
