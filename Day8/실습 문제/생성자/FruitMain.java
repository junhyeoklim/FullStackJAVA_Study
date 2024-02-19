class FruitSeller
{
	int PRICE;
	int numOfApples;
	int money;
	public FruitSeller(int PRICE, int numOfApples, int money)
	{
		this.PRICE = PRICE;		// 상수는 메소드 내에서 초기화 할 수 없다.
		this.numOfApples = numOfApples;
		this.money = money;

	}
	public int sell(int money)
	{
		this.money += money;
		int num = money / PRICE;
		this.numOfApples -= num;
		printCS();
		return num;
	}
	public void printCS()
	{
		System.out.println("사과가격 " + PRICE);
		System.out.println("사과개수 " + numOfApples);
		System.out.println("돈 " + money);	
	}
}

class Buyer
{
	int numOfApples;
	int money;
	public Buyer(int money)
	{
		this.numOfApples = 0;
		this.money = money;


	}
	public void buy(FruitSeller seller, int money)
	{
		this.money -= money;
		this.numOfApples += seller.sell(money);
		printCS();
	}
	public void printCS()
	{
		System.out.println("사과개수 " + numOfApples);
		System.out.println("돈 " + money);	
	}
}

class FruitMain
{
	public static void main(String[] args)
	{
		FruitSeller seller1 = new FruitSeller(2000, 50, 50000);
		FruitSeller seller2 = new FruitSeller(1000, 100, 100000);

		Buyer buyer = new Buyer(20000);

		buyer.buy(seller1, 6000);
		System.out.println("===================");
		buyer.buy(seller2, 5000);

	}
}

/*
과일메인 클래스


2000원짜리 사과 3개와 1000원짜리 사과 5개를 구매한다.
우선은 정확히 자신이 사고싶은 만큼의 돈을 넘겨주고 거스름돈은 없는 걸로 하자.
사과 구매후 3명(과일장수, 구매자)의 상태를 출력한다.
*/