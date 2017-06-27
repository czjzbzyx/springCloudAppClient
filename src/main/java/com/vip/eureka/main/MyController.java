/**
 * 
 */
package com.vip.eureka.main;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.method.OAuth2MethodSecurityConfiguration;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.PageHelper;
import com.vip.eureka.exception.BusinessException;

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
	
	
	
	
	@RequestMapping("/helloException")
	
	public String helloException(){
		
		try{
			
		
		int a=0;
		int b=1;
		
		int c=b/a;
		
		}catch(Exception e){
			
			throw new BusinessException(ExceptionUtils.getStackTrace(e));
		}
		return "success";
	}


	
	private @Autowired DataSourceService dataSourceService;
	
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	
	
	 @ResponseBody
	    @RequestMapping(value="/getDs/{pageNum}/{pageSize}")
	    public List<MyDataSource> getUsers(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
		 
		
		 
	        return dataSourceService.getDs(  pageNum,  pageSize);
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
