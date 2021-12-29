package com.mystudy.dockerapp.conditionalandimport;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：songdalin
 * @date ：2021-12-23 下午 04:55
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
public class TestTest {

    @Autowired
    private People people;

    @Test
    public void  test() {
        System.out.println(people.getCity().getName());
    }

}