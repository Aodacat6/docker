package com.mystudy.dockerapp.conditionalandimport;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;

/**
 * @author ：songdalin
 * @date ：2021-12-23 下午 04:51
 * @description：
 * @modified By：
 * @version: 1.0
 */
//@Import({City.class})
@Import(MyImportSelector.class)
@Configuration
public class Test {

/*    @Bean
    public City newCity() {
        City city = new City();
        city.setName("青岛");
        return city;
    }*/

    @Bean
    //@ConditionalOnBean(City.class)
    @ConditionalOnClass(City.class)
    public People newPeople(City city) {
        People people = new People();
        people.setCity(city);
        people.setCount(100L);
        return people;
    }

}
