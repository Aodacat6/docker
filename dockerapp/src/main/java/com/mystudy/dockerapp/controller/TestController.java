package com.mystudy.dockerapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：songdalin
 * @date ：2021-06-02 下午 03:42
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "hello docker";
    }
}
