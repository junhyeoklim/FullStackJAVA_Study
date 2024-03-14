package test17;

public class PlyArgumentTest2 {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Audio());
		b.summary();
		System.out.println();
		b.refund(new Computer());
		b.summary();
	}
}
