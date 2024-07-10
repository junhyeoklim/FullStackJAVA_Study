package polymorphism;

public class SamsungTV implements TV {
	
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV 按眉 积己");
	}
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV(2) 按眉 积己");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(3) 按眉 积己");
		this.speaker = speaker;
		this.price =price;
	}
	
	public void initMethod(){
		System.out.println("===> initMethod");
	}
	public void destroyMethod(){
		System.out.println("===> destroyMethod");
	}
	public void powerOn(){
		System.out.println("SamsungTV --- 傈盔 囊促. (啊拜 : " + price + ")");
	}
	public void powerOff(){
		System.out.println("SamsungTV --- 傈盔 馋促.");
	}
	public void volumeUp(){
		speaker.volumeUp();
	}
	public void volumeDown(){
		speaker.volumeDown();
	}
}