package com.vip.eureka.exception;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String desc;
	
	
	
	public String getDesc() {
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	public BusinessException(String desc){
		super(desc);	
	}
	

}
