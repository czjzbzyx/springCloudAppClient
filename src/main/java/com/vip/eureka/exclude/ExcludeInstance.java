package com.vip.eureka.exclude;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


@Exclude
@Component
public class ExcludeInstance implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("ExcludeInstance of Exclude package initilized");
		
	}
	
	

}
