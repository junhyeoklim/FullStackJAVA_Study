package peopleData;

import data.DataGetSet;

public class Customer {
	
	DataGetSet customer = new DataGetSet();

	public Customer(int cmoney)
	{
		customer.setMoney(cmoney);
	}

	public void customerBuy(Fruiter seller,int cnt)
	{			
		if(customer.getMoney() >=0)
		{		
			customer.setMoney(customer.getMoney() - seller.fruiterSell(cnt));	
			customer.setCnt(customer.getCnt() + cnt);
		}
			
		
	}

	public void customerState()
	{
		if(customer.getMoney()>=0)
		{
			System.out.println("고객");
			System.out.println("가지고 있는 사과 갯수 : " +customer.getCnt());
			System.out.println("현재 소지금 : " +customer.getMoney());
		}
		else
		{
			System.out.println("소지금이 부족합니다!");
			System.out.println("현재 소지금 : " +customer.getMoney());
			System.out.println("가지고 있는 사과 갯수 : " +customer.getCnt());
		}
	}
}
