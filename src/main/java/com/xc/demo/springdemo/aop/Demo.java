package com.xc.demo.springdemo.aop;

import com.xc.demo.springdemo.aop.service.service2.Phone;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
	    Phone phone = context.getBean(Phone.class);
	    phone.call(1);
    }
}
