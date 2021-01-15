package com.xc.demo.springdemo.aopannotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 将注解声明为切点，在所有被注解修饰的方法上执行通知，并可以获取到注解的值
 */
public class Demo {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
	    Phone phone = context.getBean(Phone.class);
	    phone.call(1);
    }
}
