class Fruiter
{
	
	int price,fcnt,fmoney;

	public void fruiterDefine(int price,int fcnt,int fmoney)
	{
		this.price = price;
		this.fcnt = fcnt;
		this.fmoney = fmoney;
	}

	public int fruiterSell(int cnt)
	{
		fcnt = fcnt-cnt;
		fmoney = fmoney+price*cnt;
		return price*cnt;
	}

	public void fruiterState()
	{
		System.out.println("사과장수");
		System.out.println("가지고 있는 사과 갯수 : " +fcnt);
		System.out.println("현재 소지금 : " +fmoney);
	}	
}

class Customer
{
	int cnt,cmoney;

	public void customerDefine(int cmoney)
	{
		this.cmoney = cmoney;
	}

	public void customerBuy(Fruiter seller,int cnt)
	{
		cmoney -= seller.fruiterSell(cnt);
		this.cnt += cnt;
	}

	public void customerState()
	{
		System.out.println("고객");
		System.out.println("가지고 있는 사과 갯수 : " +cnt);
		System.out.println("현재 소지금 : " +cmoney);
	}
}

class FruitMain
{

	public static void main(String[] args)
	{
		Fruiter f1 = new Fruiter();
		Fruiter f2 = new Fruiter();
		Customer buyer = new Customer();

		f1.fruiterDefine(2000,50,50000);
		f2.fruiterDefine(1000,100,100000);

		buyer.customerDefine(20000);
		buyer.customerBuy(f1,0);
		buyer.customerBuy(f2,0);


		f1.fruiterState();
		f2.fruiterState();

		buyer.customerState();
	}
}

/*class Fruiter
{
	// 내가 직접 생각 해서 짠것 -> 너무 김
	int price,fcnt,fmoney;

	public void fruiterDefine(int price,int fcnt,int fmoney)
	{
		this.price = price;
		this.fcnt = fcnt;
		this.fmoney = fmoney;
	}

	public void fruiterSell(int cnt)
	{
		fcnt = fcnt-cnt;
		fmoney = fmoney+price*cnt;
	}

	public void fruiterState()
	{
		System.out.println("사과장수");
		System.out.println("가지고 있는 사과 갯수 : " +fcnt);
		System.out.println("현재 소지금 : " +fmoney);
	}	
}

class Customer
{
	int cnt,cmoney;

	public void customerDefine(int cmoney)
	{
		this.cmoney = cmoney;
	}

	public void customerBuy(int price,int cnt)
	{
		this.cnt = cnt;
		cmoney = cmoney - price*cnt;
	}

	public void customerState()
	{
		System.out.println("고객");
		System.out.println("가지고 있는 사과 갯수 : " +cnt);
		System.out.println("현재 소지금 : " +cmoney);
	}
}

class FruitMain
{

	public static void main(String[] args)
	{
		Fruiter f1 = new Fruiter();
		Fruiter f2 = new Fruiter();
		Customer custom = new Customer();

		f1.fruiterDefine(2000,50,50000);
		f2.fruiterDefine(1000,100,100000);

		custom.customerDefine(20000);

		custom.customerBuy(f1,3);
		custom.customerBuy(f2,5);

		f1.fruiterSell(3);
		f2.fruiterSell(5);


		f1.fruiterState();
		f2.fruiterState();

		custom.customerState();
	}
}*/