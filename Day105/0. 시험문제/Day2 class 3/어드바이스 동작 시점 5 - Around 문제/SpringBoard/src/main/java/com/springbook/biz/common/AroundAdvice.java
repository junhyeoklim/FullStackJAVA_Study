package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[BEFORE] : 비즈니스 메소드 수행 전에 처리할 내용 ...");
		Object returnObj = pjp.proceed();
		System.out.println("[AFTER]  : 비즈니스 메소드 수행 후에 처리할 내용 ...");
		return returnObj;
	}
}

/*
클라이언트의 요청을 가로챈 어드바이스는 클라이언트가 호출한 비즈니스 메소드를 호출하기 위해서
ProccedingJoinPoint 객체를 매개변수로 받아야 한다. ProceedingJoinPoint 객체의
procced() 메소드를 통해서 비즈니스 메소드를 호출할 수 있다.
*/