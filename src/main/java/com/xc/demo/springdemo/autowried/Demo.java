package com.xc.demo.springdemo.autowried;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 自动注入 : @Autowired
 *  1、默认按照类型去找容器中的bean，如果找到多个，再根据名称去寻找bean id。
 *  2、@Qualifier注解指定注入的bean id
 *  3、@Primary注解注释bean，在默认情况下，优先注入该注解修饰的bean
 *  4、优先级 : @Qualifier -> @Primary -> 默认规则
 *  5、默认情况下，未找到依赖的bean会报错，可以通过将required设置为false，未找到情况下不进行注入
 *
 *  java原生注解 :
 *   1、@Resource : 默认先按照名称注入，名称未找到则按照类型注入(名称未找到，而类型有多个时报错)
 *      不支持@Primary、@Qualifier注解功能
 *   2、@Inject : 和@Autowired功能类似，但是不能设置required属性，而且需要手动导入javax.inject包
 */
public class Demo {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
        System.out.println("====================");
        Person person = context.getBean(Person.class);
        System.out.println(person);
    }
}
