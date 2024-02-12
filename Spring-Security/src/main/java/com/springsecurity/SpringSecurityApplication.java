package com.springsecurity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication { 
	
	private static final Logger logger = LogManager.getLogger(SpringSecurityApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
		
		// "ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF"
		
		logger.debug("This is trace");
		logger.info("This is info");
		logger.warn("This is warn");
		logger.error("This is error");
		logger.fatal("This is fatal");
		
	}
	
	

}
