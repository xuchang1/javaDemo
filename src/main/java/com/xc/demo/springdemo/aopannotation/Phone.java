package com.xc.demo.springdemo.aopannotation;

import org.springframework.stereotype.Component;

/**
 * @author changxu13
 * @date 2021/1/14 11:20
 */
@Component
public class Phone {

	@MyAnnotation("delete")
	public Integer call(int i) {
		System.out.println("打电话");
		return i;
	}
}
