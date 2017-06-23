package com.vip.eureka.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleCfg {
	
	
	@Bean
	public Step step1(){
		
		return new Step(0);
	}
	
	
	@Bean
	public Step step2(){
		
		return new Step(1);
	}

}
