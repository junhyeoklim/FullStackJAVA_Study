package chapter07;
//
///*
// * public class Exercise7_1 {
// * 
// * public static void main(String[] args) { SutdaDeck deck = new SutdaDeck();
// * System.out.println(deck.pick(0)); System.out.println(deck.pick());
// * deck.shuffle(); for(int i=0; i < deck.cards.length;i++)
// * System.out.print(deck.cards[i]+","); System.out.println();
// * System.out.println(deck.pick(0)); }
// * 
// * }
// */
///*
// * class Product { int price; // 제품의 가격 int bonusPoint; // 제품구매 시 제공하는 보너스점수
// * Product(int price) { this.price = price; bonusPoint =(int)(price/10.0); } }
// * class Tv extends Product { Tv() {} public String toString() { return "Tv"; }
// * } class Exercise7_5 { public static void main(String[] args) { Tv t = new
// * Tv(); } }
// */
///*
// * //class Parent { // int x=100; // // Parent() { // this(200); //
// * System.out.println("호출1 : "+x); // } // Parent(final int x) { //
// * System.out.println("호출2 : "+this.x); // // this.x = x; // // } // int getX()
// * { // System.out.println("호출3 : "+x); // return x; // } //} //class Child
// * extends Parent { // int x = 3000; // Child() { // this(1000); //
// * System.out.println("호출4 : "+x); // } // Child(int x) { //
// * System.out.println("호출5 : "+this.x); // this.x = x; // } //} //class
// * Exercise7_1 { // public static void main(String[] args) { // Child c = new
// * Child(); // System.out.println("x="+c.getX()); // } //}
// */
//
//class MyTv2 {
//	private boolean isPowerOn;
//	private int channel;
//	private int volume;	
//	final int MAX_VOLUME = 100;
//	final int MIN_VOLUME = 0;
//	final int MAX_CHANNEL = 100;
//	private int[] prevchannel = new int[MAX_CHANNEL];
//	final int MIN_CHANNEL = 1;	
//
//	public void setChannel(int channel)
//	{
//		
//		this.channel = channel;
//		prevchannel[cnt++] = channel;
//	}
//	public int getChannel()
//	{
//		return channel;
//	}
//	public void setVolume(int volume)
//	{
//		this.volume = volume;
//	}
//	public int getVolume()
//	{
//		return volume;
//	}
//	public void gotoPrevChannel()
//	{		
//		channel = prevchannel[];
//	}
//	
//}
//class Exercise7_1 {
//	public static void main(String args[]) {
//		MyTv2 t = new MyTv2();
//		t.setChannel(10);
//		System.out.println("CH:"+t.getChannel());
//		t.setChannel(20);
//		System.out.println("CH:"+t.getChannel());
//		t.gotoPrevChannel();
//		System.out.println("CH:"+t.getChannel());
//		t.gotoPrevChannel();
//		System.out.println("CH:"+t.getChannel());
//	}
//}
//class Car {}
//class FireEngine extends Car implements Movable {}
//class Ambulance extends Car {}
//
//class Exercise7_1 {
//	
//	
//	public static void main(String[] args)
//	{
//		FireEngine fe = new FireEngine();
//		System.out.println(fe instanceof Movable);
//	}
//}
//class Unit
//{
//	private int x,y;
//
//	Unit(){	}
//	void move(int x, int y)
//	{
//		this.x = x;
//		this.y = y;
//	}
//	public void stop()
//	{
//
//	}
//}
//
//class Marine extends Unit { // 보병
//	int x, y; // 현재 위치
//	void move(int x, int y) {
//		super.move(x,y);
//	}  // 지정된 위치로 이동
//	public void stop() {  }// 현재 위치에 정지
//	void stimPack() {}// 스팀팩을 사용한다
//}
//class Tank { // 탱크
//	int x, y; // 현재 위치
//	public void move(int x, int y) {}  // 지정된 위치로 이동
//	public void stop() {  }// 현재 위치에 정지
//	void changeMode() { /* . */} //공격모드를 변환한다
//}
//class Dropship { // 수송선
//	int x, y; // 현재 위치
//	public void move(int x, int y) {}  // 지정된 위치로 이동
//	public void stop() {  }// 현재 위치에 정지
//	void load() { /* .*/ } //선택된 대상을 태운다
//	void unload() { /* .*/ } //선택된 대상을 내린다
//}
//class Robot {}
//class DanceRobot extends Robot {
//	void dance() {
//		System.out.println(" 춤을 춥니다."); 
//	}
//}
//class SingRobot extends Robot {
//	void sing() {
//		System.out.println(" 노래를 합니다."); 
//	}
//}
//class DrawRobot extends Robot {
//	void draw() {
//		System.out.println(" 그림을 그립니다."); 
//	}
//}
//class Exercise7_1 {
//	public static void action(Robot r)
//	{
//		//18번 문제
//		if(r instanceof DanceRobot)
//		{
//			DanceRobot dance = new DanceRobot();
//			dance.dance();
//		}
//		else if(r instanceof SingRobot)
//		{
//			SingRobot sing = new SingRobot();
//			sing.sing();
//		}
//		else if(r instanceof DrawRobot)
//		{
//			DrawRobot draw = new DrawRobot();
//			draw.draw();
//		}
//		
//	}
//	public static void main(String[] args)
//	{
//		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot()};
//		for(int i=0; i< arr.length;i++)
//			action(arr[i]);
//	}
//}
class Exercise7_1 {
	public static void main(String args[]) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		b.summary();
	}
}
class Buyer {
	int money = 1000;
	Product[] cart = new Product[3]; // 구입한 제품을 저장하기 위한 배열
	int i = 0; // Product cart index 배열 에 사용될
	void buy(Product p) {
		if(money < p.price)
			return;
		else
		{
			money -= p.price;
			add(p);
		}
	}
	void add(Product p) {
		if(i >= cart.length)
		{
			Product[] newcart = new Product[cart.length*2];

			for(int j=0;j<cart.length;j++)
			{
				newcart[j] = cart[j]; 
			}
			newcart[cart.length-1+(i++)] = p;
		}
		else
			cart[i++] = p;

	} // add(Product p)
	void summary() {

	} // summary()
}
class Product {
	int price; // 제품의 가격
	Product(int price) {
		this.price = price;
	}
}
class Tv extends Product {
	Tv() { super(100); }
	public String toString() { return "Tv"; }
}
class Computer extends Product {
	Computer() { super(200); }
	public String toString() { return "Computer";}
}
class Audio extends Product {
	Audio() { super(50); }
	public String toString() { return "Audio"; }
}