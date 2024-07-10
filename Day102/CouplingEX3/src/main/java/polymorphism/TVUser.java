package polymorphism;

public class TVUser {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}

/*
 * 디자인 패턴 이용하기
 * 결합도를 낮추기 위한 또 다른 방법으로 디자인 패턴을 이용하는 방법이 있다. 앞에서 살펴본 다형성을 이용하는 방법은 메소드를 호출할 때
 * 인터페이스를 이용함으로써 좀 더 쉽게 TV를 교체할 수 있었다. 하지만 이 방법 역시 TV를 변경하고자 할 때, TV 클래스 객체를 생성하는
 * 소스를 수정해야만 한다.
 * 
 * TV를 교체할 때, 클라이언트 소스를 수정하지 않고 TV를 교체할 수 만 있다면 유지보수는 더욱 편리해질 것이다. 이를 위해서 Factory
 * 패턴을 적용해야 하는데, Factory 패턴은 클라이언트에서 사용할 객체 생성을 갭슐화하여 TVUser와 TV 사이를 느슨한 결합 상태로 
 * 만들어 준다. 
 * 
 * 실행되는 TV를 변경하고 싶을 때는 명령행 매개변수만 수정하여 실행한다. 결국 클라이언트 소스를 수정하지 않고도 실행되는 객체를 변경할
 * 수 있다.
 * 이런 결과를 얻을 수 있었던 것은 TV 객체를 생성하여 리턴하는 BeanFactory 때문이다. 클라이언트에 해당하는 TVUser는 자신이 필요한
 * 객체를 직접 생성하지 않는다. 만약 그랬다면 TV가 변경될 때마다 소스를 수정해야 했을 것이다. TVUser는 단지 객체가 필요하다는 것을
 * BeanFactory에 요청했을 뿌이고, BeanFactory가 클라이언트가 사용할 TV 객체를 적절하게 생성하여 넘겨준 것이다.
 */