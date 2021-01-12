package com.xc.demo.springdemo.aware;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 自定义组件，想要使用spring容器底层的一些组件，可以通过实现 XXXAware接口来操作，会调用接口规范的方法注入底层组件。
 *      1、ApplicationContextAware注入ApplicationContext
 *      2、BeanNameAware注入当前bean的名称
 *      3、EmbeddedValueResolverAware注入StringValueResolver占位符解析器，可以解析$、#号
 *      。。。。。其他类似
 * 实现原理 :
 *      通过对应的后置处理器XXXProcessor来实现的。如ApplicationContextAware -> ApplicationContextAwareProcessor
 *
 */
public class Demo {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println(context);
    }
}
