package polymorphism;

public class SamsungTV implements TV {
	
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV 객체 생성");
	}
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("===> SamsungTV(2) 객체 생성");
		this.speaker = speaker;
	}

	public void initMethod(){
		System.out.println("===> initMethod");
	}
	public void destroyMethod(){
		System.out.println("===> destroyMethod");
	}
	public void powerOn(){
		System.out.println("SamsungTV --- 전원 켠다.");
	}
	public void powerOff(){
		System.out.println("SamsungTV --- 전원 끈다.");
	}
	public void volumeUp(){
//		speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	public void volumeDown(){
//		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
}

/*
의존성 관계
의존성(Dependency)관계란 객체와 객체의 결합 관계이다. 즉, 하나의 객체에서 다른 객체의 변수나
메소드를 이용해야 한다면 이용하려는 객체에 대한 객체 생성과 생성된 객체의 레퍼런스 정보가 필요하다.
SamsungTV는 SonySpeaker의 메소드를 이용해서 기능을 수행한다. 따라서 SamsungTV는 SonySpeaker
타입의 speaker 변수를 멤버변수로 가지고 있으며, speaker 변수는 SonySpeaker 객체를 참조하고 있어야
한다. 따라서 SamsungTV 클래스 어딘가에는 SonySpeaker 클래스에 대한 객체 생성 코드가 반드시
필요하다.
클라이언트가 volumeUp()과 volumeDown() 중 어떤 메소드를 먼저 호출할지 모르기 때문에 두 메소드에
SonySpeaker 객체 생성 코드를 모두 작성했다.
하지만 이 프로그램에는 두 가지 문제가 있다. 첫 번째는 SonySpeaker 객체가 쓸데 없이 두 개나
생성되는 것이고, 두 번째는 운영 과정에서 SonySpeaker의 성능이 떨어져서 SonySpeaker를 AppleSpeaker
같은 다른 Speaker로 변경하고자 할 때, volumeUp(), volumeDown() 두 개의 메소드를 모두
수정해야 한다.
이러한 문제가 발생하는 이유는 의존관계에 있는 Speaker객체에 대한 객체 생성 코드를 직접 SamsungTV
소스에 명시했기 때문이다. 스프링은 이 문제를 의존성 주입(Dependecy Injection)을 이용하여
해결한다.
*/