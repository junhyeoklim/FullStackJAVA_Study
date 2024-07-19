package test1;

public class Buyer {

	private int money = 1000;
	private Product[] cart = new Product[3];
	private int cnt;
	
	public void buy(Product p)
	{
		if(money < p.getPrice())
		{
			System.out.println("돈이 부족합니다.");
			return;
		}
		money -= p.getPrice();
		add(p);
	}
	
	public void add(Product p)
	{		
		if(cnt >= cart.length)
		{
			Product[] newCart = new Product[cart.length*2];
			System.arraycopy(cart, 0, newCart, 0, cart.length);
			cart = newCart;
		}
		cart[cnt++]= p;
	}
	
	public void summary()
	{
		int sum = 0;
		for(int i=0;i<cart.length;i++)
		{
			System.out.print(cart[i]+",");
			sum += cart[i].getPrice();
		}
		System.out.println();
		System.out.println("사용 금액 : "+sum);
		System.out.println("남은 금액 : "+money);
	}
	
	
}
