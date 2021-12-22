package com.mystudy.dockerapp.dynloadclass;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：songdalin
 * @date ：2021-12-22 下午 04:58
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/test11")
public class TestEnvController {

        @GetMapping("/getenv")
    public String get() {
        return GetUtils.getEnv();
    }
}
