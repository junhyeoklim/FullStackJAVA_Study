package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[사전 처리] " + method + "() 메소드 ARGS 정보 : " +args[0].toString());
	}
}

/*
	횡단 관심에 해당하는 어드바이스 메소드를 의미 있게 구현하려면 클라이언트가 호출한 비즈니스 메소드의 정보가 필요하다.
	스프링에서는 이런 다양한 정보들을 이용할 수 있도록 JoinPoint 인터페이스를 제공한다.
	
	JoinPoint 메소드
	
	메소드						설명
	Signature getSignature()	클라이언트가 호출한 메소드의 시그니처(리턴타입, 이름, 매개변수) 정보가 저장된 Signature 객체 리턴
	Object getTarget()			클라이언트가 호출한 비즈니스 메소드를 포함하는 비즈니스 객체 리턴
	Object getArgs()			클라이언트가 메소드를 호출할 때 넘겨준 인자 목록을 Object 배열로 리턴
	
	Around 어드바이스 메소드를 구현할 때 사용한 ProceedingJoinPoint 인터페이스는 JoinPoint를 상속했다. 따라서 JoinPoint가 가진
	모든 메소드를 지원하며, proceed() 메소드를 추가했다고 보면 된다.
	여기서 주의할 점은 Before, After Returning, After Throwing, After 어드바이스에는 JoinPoint를 사용해야 하고, 유일하게
	Around 어드바이스에서만 proceed() 메소드가 필요하기 때문이다.
	getSignature() 메소드가 리턴하는 Signature 객체를 이용하면, 호출되는 메소드에 대한 다양한 정보를 얻을 수 있다.
	다음은 Signature가 제공하는 메소드들이다.
	
	메소드명					설명
	String getName()		클라이언트가 호출한 메소드 이름 리턴
	String toLongString()	클라이언트가 호출한 메소드의 리턴타입, 이름, 매개변수를 패키지 경로까지 포함하여 리턴
	String toShortString()	클라이언트가 호출한 메소드 시그너처를 축약한 문자열로 리턴
	
	JoinPoint 객체를 사용하려면 단지 JoinPoint를 어드바이스 메소드 매개변수로 선언만 하면된다. 그러면 클라이언트가 비즈니스 메소드를
	호출할 때, 스프링 컨테이너가 JoinPoint 객체를 생성한다. 그리고 메소드 호출과 관련된 모든 정보를 JoinPoint 객체에 저장하여
	어드바이스 메소드를 호출할 때 인자로 넘겨준다.
*/