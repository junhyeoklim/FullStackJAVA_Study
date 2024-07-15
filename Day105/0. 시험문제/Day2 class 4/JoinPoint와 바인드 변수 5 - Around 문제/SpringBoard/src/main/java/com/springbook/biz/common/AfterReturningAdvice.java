package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springbook.biz.user.UserVO;

public class AfterReturningAdvice {
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
	After Returning은 비즈니스 메소드가 수행되고 나서, 결과 데이터를 리턴할 때 동작하는 어드바이스이다. 따라서 어떤 메소드가 
	어떤  값을 리턴했는지를 알아야 사후 처리 기능을 다양하게 구현할 수 있다.
	
	afterLog() 메소드는 클라이언트가 호출한 비즈니스 메소드 정보를 알아내기 위해서 JoinPoint 객체를 첫 번째 매개변수로 선언한다.
	그리고 Object 타입의 변수도 두 번째 매개변수로 선언되어 있는데, 이를 '바인드 변수'라고 한다. 바인드 변수는 비즈니스 메소드가
	리턴한 결괏값을 바인딩할 목적으로 사용하며, 어떤 값이 리턴될지 모르기 때문에 Object 타입으로 선언한다.
	
	After Returning 어드바이스 메소드에 JoinPoint만 선언되어 있다면 스프링 설정 파일은 수정하지 않아도 된다. 하지만 바인드
	변수가 추가됐다면 반드시 바인드 변수에 대한 매핑 설정을 스프링 설정 파일에 추가해야 한다. 이때 <aop:after-returning>
	엘리먼트의 returning 속성을 사용한다.
	
	// returning="returnObj"
	 <aop:config>
		<aop:pointcut id="allPointcut" expression ="execution(* com.springbook.biz..*Impl.*(..))" />
		<aop:pointcut id="getPointcut" expression ="execution(* com.springbook.biz..*Impl.get*(..))" />
		<aop:aspect ref="afterReturning">
			<aop:after-returning pointcut-ref="getPointcut" method="afterLog" returning="returnObj"/>
		</aop:aspect>
	</aop:config>
	
	위의 설정은 비즈니스 메소드가 리턴한 결괏값을 returnObj라는 바인드 변수에 바인드하라는 설정이다. returning 속성은 
	<aop:after-returning> 엘리먼트에서만 사용할 수 있는 속성이며, 속성값은 반드시 어드바이스 메소드 매개변수로 선언된
	바인드 변수 이름과 같아야 한다.
*/