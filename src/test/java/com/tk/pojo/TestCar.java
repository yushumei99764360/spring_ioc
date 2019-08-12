package com.tk.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TK
 * @date 2019/6/22 10:58
 */
public class TestCar {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
    @Test
    public void test() {
        Car car = applicationContext.getBean("car",Car.class);
        System.out.println(car);
    }
}
