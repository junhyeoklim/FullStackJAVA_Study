//package reentranklock;
//
//class Sum
//{
//	int num;
//	public Sum() { num=0; }
//	public void addNum(int n) { num+=n; }
//	public int getNum() { return num; }
//}
//
//class AdderThread extends Sum implements Runnable
//{	
//	int start, end;
//	
//	public AdderThread(int s, int e)
//	{
//		start=s;
//		end=e;
//	}
//	public void run()
//	{
//		for(int i=start; i<=end; i++)
//			addNum(i);
//	}
//}
//
//class RunnableThread
//{
//	public static void main(String[] args)
//	{
//		AdderThread at1=new AdderThread(1, 50);
//		AdderThread at2=new AdderThread(51, 100);
//		Thread tr1=new Thread(at1);
//		Thread tr2=new Thread(at2);
//		tr1.start();
//		tr2.start();
//		
//		try
//		{
//			tr1.join();
//			tr2.join();
//		}
//		catch(InterruptedException e)
//		{
//			e.printStackTrace();
//		}
//		
//		System.out.println("1~100까지의 합: "+(at1.getNum()+at2.getNum()));
//	}
//}
