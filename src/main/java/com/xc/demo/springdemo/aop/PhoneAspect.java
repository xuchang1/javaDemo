package com.xc.demo.springdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
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
//	@Pointcut("execution(* com.xc.demo.springdemo.aop.*.*.*.*(..))")
	@Pointcut("execution(* com.xc.demo.springdemo.aop.service.service2.Phone.call(..))")
	public void callPointcut() {}

	@Before("callPointcut() && args(i)")
	public void callBefore(JoinPoint pjp, int i) {
		MethodSignature signature = (MethodSignature)pjp.getSignature();
		System.out.println("execute before method name : " + signature.getMethod().getName());
		System.out.println("call Before : " + i);
	}

	@After("callPointcut() && args(i)")
	public void callAfter(int i) {
		System.out.println("call After : " + i);
	}

	/**
	 * 如果加了@Around,该通知获取到的返回值为@Around方法返回的值
	 */
	@AfterReturning(value = "callPointcut()", returning = "retVal")
	public void callReturning(Integer retVal) {
		System.out.println("call AfterReturning : " + retVal);
	}

	@AfterThrowing(value = "callPointcut()", throwing = "ex")
	public void callThrowing(Exception ex) {
		System.out.println("call AfterThrowing : " + ex);
	}

	@Around("callPointcut()")
	public Integer callAround(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature)pjp.getSignature();
		System.out.println("method name : " + signature.getMethod().getName());
		System.out.println("call Around before");
		pjp.proceed();
		System.out.println("call Around after");
		return 2;
	}
}
