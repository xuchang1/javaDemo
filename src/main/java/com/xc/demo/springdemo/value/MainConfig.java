package com.xc.demo.springdemo.value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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

}
