package polymorphism;

public class AppleSpeaker implements Speaker {
	public AppleSpeaker(){
		System.out.println("===> AppleSpeaker 객체생성");
	}
	public void volumeUp(){
		System.out.println("AppleSpeaker---소리 올린다.");
	}
	public void volumeDown(){
		System.out.println("AppleSpeaker---소리 내린다.");
	}
}