/**
 * 
 */
package com.vip.eureka.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
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

	
	private @Autowired DataSourceService dataSourceService;
	
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	
	
	 @ResponseBody
	    @RequestMapping(value="/getDs")
	    public List<MyDataSource> getUsers(){
	        return dataSourceService.getDs();
	    }
	 
	 
	 @ResponseBody
	    @RequestMapping(value="/{id}")
	    public String updateById(@PathVariable Long id)throws Exception{
		 dataSourceService.updateById(id);
	         
	         return "success";
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
