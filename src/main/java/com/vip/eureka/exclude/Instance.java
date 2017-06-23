package com.vip.eureka.exclude;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


@Component
public class Instance implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("Instance of Exclude package initilized");
		
	}
	
	

}
