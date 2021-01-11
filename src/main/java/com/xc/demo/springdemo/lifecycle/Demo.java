package com.xc.demo.springdemo.lifecycle;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ioc容器的生命周期
 * 构造对象创建 :
 *      单实例 : 在容器启动的时候创建对象
 *      多实例 : 在每次获取的时候创建对象
 * 初始化方法 :
 *       对象创建完成，并赋值好，调用初始化方法
 * 销毁 :
 *      单实例 : 容器关闭的时候
 *      多实例 : 容器不会管理这个bean，容器不会调用销毁方法
 *
 *
 * 管理bean生命周期的方法
 *      1、通过@Bean指定initMethod、destroyMethod
 *      2、通过让Bean实现InitializingBean、DisposableBean接口
 *      3、可以使用JSR250 :
 *          @PostConstruct : 在bean创建完成并且属性赋值完成，来执行初始化方法
 *          @PreDestroy : 在容器销毁bean之前通知我们进行清理工作
 *      4、BeanPostProcessor接口 : bean的后置处理器，在bean初始化前后进行一些工作
 *          postProcessBeforeInitialization : 在初始化之前工作
 *          postProcessAfterInitialization : 在初始化之后工作
 *
 * BeanPostProcessor的执行原理 : 查看源码可以看到，在初始化方法调用前后，分别执行了BeanPostProcessor的before及after方法
 *
 *      先去设置属性，设置完属性后，再去调用初始化方法
 *      populateBean(beanName, mbd, instanceWrapper);
 *      初始化方法的执行逻辑
 *      exposedObject = initializeBean(beanName, exposedObject, mbd);
 *      {
 *          wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *          invokeInitMethods(beanName, wrappedBean, mbd);
 *          wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *      }
 *
 * BeanPostProcessor在spring源码中的使用
 *      1、一个类实现ApplicationContextAware接口后，可以通过重写其setApplicationContext方法，获取IOC容器的context。
 *          通过ApplicationContextAwareProcessor这个bean的后置处理器实现类来实现该功能的。
 *      2、BeanValidationPostProcessor对象初始化前后数据校验
 *      3、InitDestroyAnnotationBeanPostProcessor实现@PostConstruct、@PreDestroy注解功能
 *      4、AutowiredAnnotationBeanPostProcessor处理自动注入注解@Autowired
 *      5、AsyncAnnotationBeanPostProcessor对@Async的处理
 */
public class Demo {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = context.getBean(Person.class);
        context.close();
    }
}
