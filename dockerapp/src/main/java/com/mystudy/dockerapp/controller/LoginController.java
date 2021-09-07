package com.mystudy.dockerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ：songdalin
 * @date ：2021-09-07 下午 08:00
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     *   第一种：登录信息放在session中
     */
    @PostMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        User user = new User("xiaoming", 10);
        session.setAttribute("token", user);
    }


    @GetMapping("/getuser")
    public User getUser(HttpSession session) {
        User user = (User) session.getAttribute("token");
        return user;
    }

    @PostMapping("/login-v1")
    public void loginv1(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        User user = new User("xiaoming", 10);
        redisTemplate.opsForValue().set("user:" + user.getName(), user);
        session.setAttribute("token", user.getName());
    }


    @GetMapping("/getuser-v1")
    public User getUserv1(HttpSession session) {
        String token = (String) session.getAttribute("token");
        if (StringUtils.isEmpty(token)) {
            throw new RuntimeException("未登录~~");
        }
        User user = (User)redisTemplate.opsForValue().get("user:" + token);
        return user;
    }
}
