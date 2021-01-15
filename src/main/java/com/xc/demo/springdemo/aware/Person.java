package com.xc.demo.springdemo.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

public class Person implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware, ResourceLoaderAware {

    private String name;

    private int age;

    private String nickName;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
        System.out.println("person ... constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("=============" + applicationContext);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("=============" + name);
    }

    //StringValueResolver解析$、#号占位符
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("=============" + resolver.resolveStringValue("你好 #{20-10}，${os.name}"));
    }

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println("=============" + resourceLoader);
	}
}
