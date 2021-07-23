package com.mystudy.dockerapp.controller;

import com.mystudy.dockerapp.annotation.MyAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.constraints.NotNull;

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

    @PostMapping("/submit")
    public String submit(){
        return "submit success";
    }

    @MyAnnotation(name = "this is cancle")
    @GetMapping("/cancle")
    public String cancle() {
        return "cancle success";
    }

    @GetMapping("/testnot/{str}")
    public String test(@PathVariable("str") @NotNull(message = "not null~~") String str) {
        return str;
    }
}
