package com.mystudy.dockerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ：songdalin
 * @date ：2021-08-10 下午 06:33
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/session")
public class RedisSessionController {

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/get")
    public String getSession(HttpSession session) {
        redisTemplate.opsForValue().set("b", "bb");
        String a = (String) redisTemplate.opsForValue().get("b");
        String name = (String) session.getAttribute("catname");
        return "b:" + a + "   name:" + name;
    }

    @GetMapping("/set")
    public void setSession(HttpSession session) {
        session.setAttribute("catname", "damiao");
    }
}
