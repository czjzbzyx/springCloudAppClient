/**
 * 
 */
package com.vip.eureka.main;

import org.springframework.util.StopWatch;

/**
 * @author fang08.li
 *
 */
public class TEST {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start("测试");
		Thread.sleep(10000);
		test2();
		
		stopWatch.stop();
		
		
		System.out.println(stopWatch.prettyPrint());
		

	}
	
	
	
	public static void test2(){
		StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
		for(StackTraceElement stackTraceElement:stackTrace){
			
			System.out.println(stackTraceElement.getClassName()+"|"+stackTraceElement.getMethodName());
		}
	}

}
