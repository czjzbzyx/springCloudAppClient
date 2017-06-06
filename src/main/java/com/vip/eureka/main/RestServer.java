/**
 * 
 */
package com.vip.eureka.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author fang08.li
 *
 */

@Service
public class RestServer {

	
	@Autowired

	private  RestTemplate restTemplate; 
	
	

	
	
	private static final String SERVICE_NAME="app-service2";
	
	
	
	
	@HystrixCommand(fallbackMethod = "fallbackSayHi")
	
	public String sayHi() {
		
		
//		List<ServiceInstance> serviceInstances= discoveryClient.getInstances(SERVICE_NAME);
//		
//		if(serviceInstances!=null && serviceInstances.size()>0){
//			
//			for(ServiceInstance instance:serviceInstances){
//				System.out.println(instance.getUri());
//				
//				return restTemplate.getForObject(instance.getUri()+"/hello", String.class);
//			}
//		}
//		
//		
//		return "no service found";
		 return restTemplate.getForObject("http://"+SERVICE_NAME+"/hello", String.class);
	}
	
	public String fallbackSayHi(){
		
		return "fallbackSayHi";
	}
	
	
	
	
	
	
	
	
}
