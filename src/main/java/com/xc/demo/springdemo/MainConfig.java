package com.xc.demo.springdemo;

import org.springframework.context.annotation.*;

//@ComponentScan(value = "com.xc.demo.springdemo", useDefaultFilters = false, includeFilters = {
//        @ComponentScan.Filter(type = FilterType.CUSTOM, value = {MyTypeFilter.class})
//})
//@Import(Person.class)
//@Import(MyImportSelector.class)
//@Import(MyImportBeanDefinitionRegistrar.class)
@Import(MyFactoryBean.class)
@Configuration
public class MainConfig {

//    @Bean
//    public Person person2() {
//        return new Person("小红");
//    }
//
//    @Conditional({MyCondition.class})
//    @Bean
//    public Person person1() {
//        return new Person("小明");
//    }
}
