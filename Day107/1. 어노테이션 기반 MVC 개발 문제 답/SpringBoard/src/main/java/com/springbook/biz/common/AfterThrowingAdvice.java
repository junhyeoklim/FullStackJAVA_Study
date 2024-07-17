package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.board.impl.BoardService;

@Service
@Aspect
public class AfterThrowingAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@AfterThrowing(pointcut="allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		
		System.out.println(method + "() 메소드 수행 중 예외 발생!");
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력되었습니다.");
		} else if(exceptObj instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아닙니다.");
		} else if(exceptObj instanceof Exception) {
			System.out.println("문제가 발생했습니다.");
		}
	}
	
}


/*
	exceptionLog() 메소드가 After Throwing 형태로 동작하도록 메소드 위에 @AfterThrowing 어노테이션을 추가했다.
	@AfterThrowing은 앞에서 설정한 @AfterReturning과 마찬가지로 pointcut 속성을 이용하여 포인트컷을 참조하고 있다.
	이는 @AfterThrowing 역시 비즈니스 메소드에서 발생된 예외 객체를 받아낼 바인드 변수를 지정해야 하기 때문이다.
	
	XML 설정에서는 throwing 속성을 사용하여 바인드 변수를 명확하게 지정할 수 있었다. 어노테이션 설정에서도 throwing
	속성을 이용하여 바인드 변수를 지정할 수 있다.
	
	<aop:aspect ref="afterThrowing">
		<aop:after-throwing pointcut-ref="allPointcut" method="exceptLog" throwing="exceptObj" />
	</aop:aspect>
	
	
	@AfterThrowing이 발생하는 것을 확인하기 위해 BoardServiceImpl 클래스에서 강제로 예외를 발생시켰다.	

	@Override
	public void insertBoard(BoardVO vo) {
		int num = 0;
		if(num==0) throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
		boardDAO.insertBoard(vo);
	}	
	
	BoardServiceClient의 main 메소드를 실행시켜 실행결과를 확인하자.
*/