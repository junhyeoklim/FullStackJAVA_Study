package polymorphism;

public class LgTV implements TV {
	public void powerOn(){
		System.out.println("LgTV --- ���� �Ҵ�.");
	}
	public void powerOff(){
		System.out.println("LgTV --- ���� ����.");
	}
	public void volumeUp(){
		System.out.println("LgTV --- �Ҹ� �ø���.");
	}
	public void volumeDown(){
		System.out.println("LgTV --- �Ҹ� ������.");
	}
}
