package com.mystudy.dockerapp.conditionalandimport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：songdalin
 * @date ：2021-12-23 下午 05:02
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping
public class CondController {
    @Autowired
    private People people;


    @GetMapping("/getp")
    public String getPeople() {
        return people.getCity().getName();
    }
}
