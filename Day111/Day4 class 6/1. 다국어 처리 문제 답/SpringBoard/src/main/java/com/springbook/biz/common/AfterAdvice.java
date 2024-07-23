package com.springbook.biz.common;

public class AfterAdvice {
	public void allPointcut() {}
	
	public void finallyLog() {
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 무조건 동작");
	}
}

/*
	finallyLog() 메소드가 After Advice 형태로 동작하도록 @Advice 어노테이션을 선언했다.
	그리고 finallyLog() 메소드에 바인드 변수가 없으므로 @After 설정은 @Before처럼 포인트컷
	메소드만 참조하면 된다. BoardServiceClient의 main 메소드를 실행한다. 예외가 발생해도
	동작하는 것을 확인할 수 있다.
*/