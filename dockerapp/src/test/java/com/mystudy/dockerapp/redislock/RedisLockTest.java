package com.mystudy.dockerapp.redislock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * @author ：songdalin
 * @date ：2021-12-24 上午 10:43
 * @description：
 * @modified By：
 * @version: 1.0
 */
//必须加@springboottest注解
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisLockTest {

    @Autowired
    private RedisLock redisLock;

    @Test
    public void lock() throws InterruptedException {
        redisLock.lock();
    }
}