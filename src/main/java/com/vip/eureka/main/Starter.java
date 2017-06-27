/**
 * 
 */
package com.vip.eureka.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.vip.eureka.exclude.Exclude;

/**
 * @author fang08.li
 *
 */

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@EnableZuulProxy
@ComponentScan("com.vip.eureka.lifecycle")
@ComponentScan("com.vip.eureka.exception")
@ComponentScan("com.vip.eureka.mvcextend")
@ComponentScan("com.vip.eureka.homepage")
@ComponentScan("com.vip.eureka.main")
@ComponentScan(value="com.vip.eureka.exclude",excludeFilters={@ComponentScan.Filter(type= FilterType.ANNOTATION,value={Exclude.class})})
@MapperScan(value="com.vip.eureka.mapper")

//org.mybatis.spring.mapper.MapperScannerConfigurer
public class Starter {
	

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		
		ConfigurableApplicationContext ctx = SpringApplication.run(Starter.class, args);
		
		
		Object bean = ctx.getBean("step1");
		if(bean!=null){
			
			System.out.println(bean.getClass());
			bean=null;
		}
		
		Thread.sleep(5000);
		Object bean2 = ctx.getBean("step1");
		if(bean2!=null){
			
			System.out.println(bean2.getClass());
			bean2=null;
		}
		
		BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry)ctx.getBeanFactory();
		
		beanFactory.removeBeanDefinition("step1");
		
		System.out.println(ctx.getClass());
	}
	

}
