package com.xc.demo.springdemo.aware;

import org.springframework.context.annotation.*;

@PropertySource(value = {"person.properties"})
@ComponentScan
@Configuration
public class MainConfig {

    @Bean
    public Person person() {
        return new Person();
    }

}
