package com.yuhs.admin.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/*
 * 인증(Authentication), 권한부여(Authorization), 접근제어(Access Control)
 * */
//@Aspect
//@Component
public class HttpRequestAuthorityChecker {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

//	@Around("execution(* com.yuhs.admin.controller..*.*(..))")
	public Object logging(ProceedingJoinPoint allJoinPoint) throws Throwable {
		Object result = allJoinPoint.proceed();
		log.info("HttpRequestAuthorityChecker info");
		log.debug("HttpRequestAuthorityChecker debug");
		return result;
	}
}
