package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {
	public void printLog(JoinPoint jp) {
		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
	}
}

///////////////////////////////////////////////////////////////////////////////

//package com.springbook.biz.common;
//
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Service;
//
//@Service
//@Aspect			// Aspect = Pointcut + Advice
//public class LogAdvice {
//	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
//	public void getPointcut() {}
//	
//	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
//	public void allPointcut() {}
//	
//	
//	@Before("allPointcut()")
//	public void printLog() {
//		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
//	}
//}


/*
	어노테이션 설정으로 포인트컷을 선언할 때는 @Pointcut을 사용하며, 하나의 어드바이스 클래스 안에
	여러 개의 포인트컷을 선언할 수 있다. 따라서 여러 포인트 컷을 식별하기 위한 식별자가 필요한데, 이때
	참조 메소드를 이용한다.
	참조 메소드는 메소드 몸체가 비어있는, 즉 구현 로직이 없는 메소드이다. 따라서 어떤 기능처리를 목적으로
	하지 않고 단순히 포인트컷을 식별하는 이름으로만 사용된다.
	
	위 소스는 allPointcut()과 getPointcut() 메소드 위에 각각 @Pointcut을 이용하여 두 개의 포인트컷을
	선언했다. 그러면 이후에 이 포인트컷을 참조할 때, @Pointcut이 붙은 참조 메소드 이름을 이용하여 특정
	포인트컷을 지정할 수 있다.
	
	어드바이스 동작 시점과 관련된 어노테이션
	
	오노테이션				설명
	@Before				비즈니스 메소드 실행 전에 동작
	@AfterReturning		비즈니스 메소드가 성공적으로 리턴되면 동작
	@AfterThrowing		비즈니스 메소드 실행 중 예외가 발생하면 동작(마치 try~catch 블록에서 catch 블록에 해당)
	@After				비즈니스 메소드가 실행된 후, 무조건 실행(try~catch~finally 블록에서 finally 블록에 해당)
	@Around				호출 자체를 가로채 비즈니스 메소드 실행 전후에 처리할 로직을 삽입할 수 있음
	
	LogAdvice 클래스 위에 @Aspect가 설정되었으므로 스프링 컨테이너는 LogAdvice 객체를 애스팩트 객체로 인식한다.
	그리고 LogAdvice에는 포인트컷 메소드(allPointcut())와 어드바이스 메소드(printLog())가 성언되어 있는데,
	이 두 메소드에 설정된 어노테이션에 의해 위빙이 처리된다.
	
	위 소슨느 allPointcut() 메소드로 지정한 포인트컷 메소드가 호출될 때, printLog()라는 어드바이스 메소드가
	실행되도록 설정한 것이다. 그리고 이 printLog() 메소드 위에 @Before가 설정되었으므로 printLog() 메소드는 사전 처리
	형태로 동작한다.
*/