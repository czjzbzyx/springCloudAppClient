package com.vip.eureka.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.SmartLifecycle;

public class Step implements SmartLifecycle,DisposableBean{
	
	private int phase;
	
	Step(int phase){
		this.phase=phase;
	}

	@Override
	public void start() {
		
		
		System.out.println("Step("+phase+") start!");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Step("+phase+") stop!");
	}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;  //初始化启动时候，这个只有未运行状态，才会启动
	}

	@Override
	public int getPhase() {
		// TODO Auto-generated method stub
		return phase;
	}

	@Override
	public boolean isAutoStartup() {
		// TODO Auto-generated method stub
		return true; //设置context初始化时能够自己启动
	}

	@Override
	public void stop(Runnable callback) {
		// TODO Auto-generated method stub
		
		callback.run();
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Step("+phase+") destroy!");
		
	}

}
