package com.vip.eureka.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	public String handlerException(HttpServletRequest request, Exception ex){
		
		return ExceptionUtils.getStackTrace(ex);
	}
	
	//http://10.107.66.71:8768/helloException
	@ExceptionHandler(BusinessException.class)
	public String handlerBusinessException(HttpServletRequest request, Exception ex){
		
		return ex.getClass().toString();
	}
	

}
