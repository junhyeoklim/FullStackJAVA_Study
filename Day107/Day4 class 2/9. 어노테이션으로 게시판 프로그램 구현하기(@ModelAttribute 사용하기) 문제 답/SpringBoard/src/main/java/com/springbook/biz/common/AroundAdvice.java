package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public void allPointcut(){}
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object obj = pjp.proceed();
		
		stopWatch.stop();
		
		System.out.println(method +"() 메소드 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		System.out.println("obj " + obj);
		System.out.println("==============================================================================");
		return obj;
	}
}

/*
	Around 어드바이스는 하나의 어드바이스로 사전, 사후 처리를 모두 해결하고자 할 때 사용하며, @Around 어노테이션을 사용하여
	설정한다.
	
	aroundLog() 메소드를 Around 어드바이스로 동작시키기 위해서 메소드 위에 @Around 어노테이션을 추가했다. 그리고 aroundLog()
	메소드도 바인드 변수가 없으므로 포인트컷 메소드만 참조하면 된다. 다시 한 번 강조하지만 어드바이스 메소드 중에서 유일하게
	Around 메소드에서만 JoinPoint가 아닌 ProceedingJoinPoint 객체를 매개변수로 받는다. 그래야 proceed() 메소드를 이용하여
	클라이언트가 호출한 비즈니스 메소드를 실행할 수 있기 때문이다.
	
	UserServiceClient 프로그램을 실행하여 실행 결과를 확인한다.
*/