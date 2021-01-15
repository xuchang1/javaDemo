package com.xc.demo.springdemo.aop.service.service2;

import org.springframework.stereotype.Component;

/**
 * @author changxu13
 * @date 2021/1/14 11:20
 */
@Component
public class Phone {

	public Integer call(int i) {
		System.out.println("打电话");
		return i;
	}
}
