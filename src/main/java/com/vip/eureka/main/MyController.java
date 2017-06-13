/**
 * 
 */
package com.vip.eureka.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author fang08.li
 *
 */

@RestController
public class MyController {

	
	@Autowired
	private RestServer  server;
	
	
	@RequestMapping("/hello")
	
	public String hello(){
		
		return server.sayHi();
	}
	
	
	  @Autowired
	 public ExamPleMapper examPleMapper;
	
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	
	
	 @ResponseBody
	    @RequestMapping(value="/gu")
	    public List<MyDataSource> getUsers(){
	        return examPleMapper.getDs();
	    }
	 
	 
	 
	@RequestMapping("/services")
	public List<String> genericScheduledExecutorService(){
		
		
		return discoveryClient.getServices();
		
	}
	
	
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
