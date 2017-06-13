/**
 * 
 */
package com.vip.eureka.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author fang08.li
 *
 */

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@EnableZuulProxy
@MapperScan(value="com.vip.eureka.mapper")
//org.mybatis.spring.mapper.MapperScannerConfigurer
public class Starter {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		ConfigurableApplicationContext run = SpringApplication.run(Starter.class, args);
		
		System.out.println(run.getClass());
	}
	

}
