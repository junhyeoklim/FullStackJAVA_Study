package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut(){}
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointcut(){}
}

/*
	외부 Pointcut 참조하기
	XML 설정으로 포인트컷을 관리했을 때는 스프링 설정 파일에 포인트컷을 여러 개 등록했다.
	그리고 애스팩트를 설정할 때 pointcut-ref 속성으로 특정 포인트컷을 참조할 수 있었기
	때문에 포인트컷을 재사용할 수 있었다.
	
	<aop:config>
		<aop:pointcut id="allPointcut" expression="execution(* com.springbook.biz..*Impl.*(..))" />
		<aop:pointcut id="getPointcut" expression="execution(* com.springbook.biz..*Impl.get*(..))" />
		
		<aop:aspect ref="log">
			<aop:before pointcut-ref="allPointcut" method="printLog" />
		</aop:aspect>
	</aop:config>
	
	하지만 어노테이션 설정으로 변경하고부터는 어드바이스 클래스마다 포인트컷 설정이 포함되면서,
	비슷하거나 같은 포인트컷이 반복 선언되는 문제가 발생한다. 스프링은 이런 문제를 해결하고자
	포인트컷을 외부에 독립된 클래스에 따로 설정하도록 한다.
	
	위와 같이 정의된 포인트컷을 참조하려면 클래스 이름과 참조 메소드 이름을 조합하여 지정해야 한다.
	
	BeforeAdvice, AfterReturningAdvice를 외부 Pointcut으로 수정한 후에
	UserServiceClient의 main 메소드를 실행하여 실행결과를 본다.
*/