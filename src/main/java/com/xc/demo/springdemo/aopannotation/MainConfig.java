package com.xc.demo.springdemo.aopannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class MainConfig {

	@Bean
	public PhoneAspect phoneAspect() {
		return new PhoneAspect();
	}
}
