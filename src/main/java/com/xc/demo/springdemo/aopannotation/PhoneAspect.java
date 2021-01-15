package com.xc.demo.springdemo.aopannotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author changxu13
 * @date 2021/1/14 11:20
 */
@Aspect
public class PhoneAspect {

	/**
	 * 1、.表示一个包的分隔，*匹配任意字符, ..匹配包及其子包，方法参数任意匹配使用..
	 * 2、
	 */
	@Pointcut("@annotation(myAnnotation)")
	public void callPointcut(MyAnnotation myAnnotation) {}

	@Before("callPointcut(myAnnotation)")
	public void callBefore(JoinPoint jp, MyAnnotation myAnnotation) {
		System.out.println("call Before : " + myAnnotation.value());
	}

	@After("callPointcut(myAnnotation)")
	public void callAfter(MyAnnotation myAnnotation) {
		System.out.println("call After : " + myAnnotation.value());
	}

	/**
	 * 如果加了@Around,该通知获取到的返回值为@Around方法返回的值
	 */
	@AfterReturning(value = "callPointcut(myAnnotation)", returning = "retVal")
	public void callReturning(Integer retVal, MyAnnotation myAnnotation) {
		System.out.println("call AfterReturning : " + retVal);
	}

	@AfterThrowing(value = "callPointcut(myAnnotation)", throwing = "ex")
	public void callThrowing(Exception ex, MyAnnotation myAnnotation) {
		System.out.println("call AfterThrowing : " + ex);
	}

	@Around("callPointcut(myAnnotation)")
	public Integer callAround(ProceedingJoinPoint pjp, MyAnnotation myAnnotation) throws Throwable {
		MethodSignature signature = (MethodSignature)pjp.getSignature();
		System.out.println("method name : " + signature.getMethod().getName());
		System.out.println("call Around before");
		pjp.proceed();
		System.out.println("call Around after");
		return 2;
	}
}
