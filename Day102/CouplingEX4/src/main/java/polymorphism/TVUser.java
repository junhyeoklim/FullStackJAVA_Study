package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		TV tv = (TV) factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		factory.close();
	}
}

/*
① TVUser 클라이언트가 스프링 설정 파일을 로딩하여 컨테이너 구동
② 스프링 설정 파일에 <bean> 등록된 SamsungTV 객체 생성
③ getBean() 메소드로 이름이 'tv'인 객체를 요청(Lookup)
④ SamsungTV 객체 반환

중요한 것은 실행되는 TV를 LgTV로 변경할 때, applicationContext.xml 파일만 수정하면 된다는 점이다.
즉, TVUser 클라이언트 소스를 수정하지 않고도 동작하는 TV를 변경할 수 있으며, 기존에 BeanFactory
클래스를 사용했던 것보다 유지보수가 좀 더 편해졌다 할 수 있다.
*/