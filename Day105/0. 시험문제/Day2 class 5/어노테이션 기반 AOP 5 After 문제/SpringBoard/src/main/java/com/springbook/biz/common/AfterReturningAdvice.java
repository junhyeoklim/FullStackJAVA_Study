package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

public class AfterReturningAdvice {
	public void getPointcut() {}
	
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + " 로그인(Admin)");
			}
		}
		System.out.println("[사후 처리] " + method + "() 메소드 리턴값 : " + returnObj.toString());
	}
}


/*
	After Returning 어드바이스
	After Returning 어드바이스는 비즈니스 메소드가 리턴한 결과 데이터를 다른 용도로 처리할 때 사용한다.
	
	afterLog() 메소드가 After Returning 형태로 동작하도록 메소드 위에 @AfterReturning 어노테이션을 추가했다.
	그런데 @AfterReturning은 앞에서 설정한 @Before와 다르게 pointcut 속성을 이용하여 포인트컷을 참조하고 있다.
	이는 After Returning 어드바이스가 비즈니스 메소드 수행 결과를 받아내기 위해서 바인드 변수를 지정해야 하기
	때문이다.
	XML 설정에서도 returning 속성을 사용하여 바인드 변수를 명확하게 지정할 수 있었다. 어노테이션 설정에서도
	returning 속성을 이용하여 바인드 변수를 지정할 수 있다.
	
	<aop:aspect ref="afterReturning">
		<aop:after-returning pointcut-ref="getPointcut" method="afterLog" returning="returnObj"/>
	</aop:aspect>
*/