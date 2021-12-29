package com.mystudy.dockerapp.redislock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author ：songdalin
 * @date ：2021-12-24 上午 10:39
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
public class RedisLock {

    /**
     * 存userid
     */
    //private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    @Autowired
    private RedisTemplate redisTemplate;

    public void lock() throws InterruptedException {

        final String KEY = "LOCK";

        Random random = new Random();
        String user = String.valueOf(random.nextInt(100));
        //THREAD_LOCAL.set(user);
        //上锁
        //Boolean lock = redisTemplate.opsForValue().setIfAbsent(KEY, user, 5000, TimeUnit.MILLISECONDS);
        final Boolean lock = lock(KEY, user, "10");
        if (lock != null && lock) {
            //dosomething
            Thread.sleep(10 * 1000);

            //解锁
            unLock(KEY, user);
        }



    }


    /**
     * 加锁
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public Boolean lock(String key, String value, String seconds){
        try{
            String path = "redis_lock.lua";
            ClassPathResource resource = new ClassPathResource(path);
            ScriptSource scriptSource = new ResourceScriptSource(resource);
            DefaultRedisScript defaultRedisScript = new DefaultRedisScript();
            defaultRedisScript.setScriptSource(scriptSource);

            System.out.println("=========script is " + scriptSource.getScriptAsString());

            //设置返回类型
            defaultRedisScript.setResultType(Long.class);

            //组装数据
            List<Object> keyList = new ArrayList<>();
            keyList.add(key);
            keyList.add(value);
            keyList.add(seconds);
            // 第三个参数是无用的,但不能为空，考虑到内存空间，遂作故用
            Long result = (Long)redisTemplate.execute(defaultRedisScript, keyList);
            return result == 1;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("redis分布式锁存在异常,请注意key:{"+key+"},value:{"+value+"}, seconds:{"+seconds+"}" );
            return false;
        }
    }

    /**
     * 解锁
     * @param key
     * @param value
     * @return
     */
    public Boolean unLock(String key, String value){
        try{
            String path = "redis_unlock.lua";
            ClassPathResource resource = new ClassPathResource(path);
            ScriptSource scriptSource = new ResourceScriptSource(resource);
            DefaultRedisScript defaultRedisScript = new DefaultRedisScript();
            defaultRedisScript.setScriptSource(scriptSource);

            System.out.println("=========script is " + scriptSource.getScriptAsString());

            //设置返回类型
            defaultRedisScript.setResultType(Long.class);

            //组装数据
            List<Object> keyList = new ArrayList<>();
            keyList.add(key);
/*            //组装第二个参数
            List<Object> argvList = new ArrayList<>();
            argvList.add(value);*/
            // 第三个参数是无用的,但不能为空，考虑到内存空间，遂作故用
            Long result = (Long)redisTemplate.execute(defaultRedisScript, keyList, value);
            return result == 1;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("redis分布式锁存在异常,请注意key:{"+key+"},value:{"+value+"}" );
            return false;
        }
    }

}
