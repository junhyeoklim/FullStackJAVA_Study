package peopleData;

import data.DataGetSet;

public class Fruiter {
	
	DataGetSet fruiter = new DataGetSet();	
	
	public void fruiterDefine(int price,int fcnt,int fmoney)
	{
		fruiter.setPrice(price);
		fruiter.setCnt(fcnt);
		fruiter.setMoney(fmoney);
	}

	public int fruiterSell(int cnt)
	{		
		
	 
		fruiter.setCnt(fruiter.getCnt()-cnt);
		fruiter.setMoney(fruiter.getMoney()+fruiter.getPrice()*cnt);
		
		return fruiter.getPrice()*cnt;
		
	}

	public void fruiterState()
	{
		
		System.out.println("사과장수");
		System.out.println("가지고 있는 사과 갯수 : " +fruiter.getCnt());
		System.out.println("현재 소지금 : " +fruiter.getMoney());
		
	}	
}
