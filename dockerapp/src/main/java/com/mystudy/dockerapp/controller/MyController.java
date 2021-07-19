package com.mystudy.dockerapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * @author ：songdalin
 * @date ：2021-07-18 下午 08:26
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("")
public class MyController {

    @GetMapping("/get")
    public String get(String name, String password, String type) {
       return "name: " + name + "password: " + password + "type: " + type;
    }
}
