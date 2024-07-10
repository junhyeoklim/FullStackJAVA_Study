package polymorphism;

public class SamsungTV implements TV {
	public SamsungTV() {
		System.out.println("===> SamsungTV 객체생성");
	}	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리...");
	}
	public void powerOn(){
		System.out.println("SamsungTV --- 전원 켠다.");
	}
	public void powerOff(){
		System.out.println("SamsungTV --- 전원 끈다.");
	}
	public void volumeUp(){
		System.out.println("SamsungTV --- 소리 올린다.");
	}
	public void volumeDown(){
		System.out.println("SamsungTV --- 소리 내린다.");
	}
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
}