package com.mystudy.dockerapp.redissession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author ：songdalin
 * @date ：2021-08-10 下午 09:10
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Configuration
@EnableRedisHttpSession
public class RedisHttpSessionConfig {

    @Bean
    public RedisConnectionFactory connectionFactory() throws Exception {
        return new LettuceConnectionFactory();
    }

}
