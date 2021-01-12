package com.xc.demo.springdemo.autowried;

import org.springframework.context.annotation.*;

//@PropertySource 读取外部配置文件的k/v保存到运行的环境变量中
//@PropertySource(value = {"classpath:/person.properties"})
@PropertySource(value = {"person.properties"})
@ComponentScan
@Configuration
public class MainConfig {

    @Bean
    public Person person() {
        return new Person();
    }

    @Primary
    @Bean
    public Man man2() {
        Man man = new Man();
        man.setName("2");
        return man;
    }


}
