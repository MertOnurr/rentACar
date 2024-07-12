package com.kodlamaio.rentACar2.core.utilities.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
	@Before("exception(*com.kodlamaio.rentACar.busi)")
	public void log() {
System.out.println( );
	}
	
}
