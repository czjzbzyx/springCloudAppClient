package com.vip.eureka.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LogController {
	
	
	Logger  logger=LoggerFactory.getLogger(LogController.class);
	
	
	@GetMapping("/log")
	public void log(){
		
		logger.info("LogController.log(info)");
		
		logger.debug("LogController.log(debug)");
	}

}
