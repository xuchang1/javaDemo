package com.xc.demo.springdemo.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class MainConfig {

    /**
     * @ Bean注解构建bean实例时，通过initMethod、destroyMethod指定初始化、销毁方法
     */
//    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Person person() {
        return new Person();
    }

    @Bean
    public Cat cat() {
        return new Cat();
    }
}
