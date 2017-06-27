package com.vip.eureka.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
//	@ExceptionHandler(Exception.class)
//	public String handlerException(HttpServletRequest request, Exception ex){
//		
//		return "GlobalExceptionHandler(handlerException):"+ex.getMessage();
//	}
	
	//http://10.107.66.71:8768/helloException
	@ExceptionHandler(BusinessException.class)
	public String handlerBusinessException(HttpServletRequest request, Exception ex){
		
		return "GlobalExceptionHandler(handlerBusinessException):"+ex.getClass().toString();
	}
	

}
