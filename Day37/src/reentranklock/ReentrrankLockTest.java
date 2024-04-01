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
//class AdderThread extends Thread
//{	
//	int start,end;
//	Sum sm;
//	
//	public AdderThread(int start,int end) {
//		this.start = start;
//		this.end = end;
//	}
//	
//	@Override
//	public void run() {
//		sm = new Sum();
//		
//		for(int i=start; i<=end;i++)
//		{
//			sm.addNum(i);
//		}
//	}
//	
//}
//
//
//class ReentrrankLockTest
//{
//	public static void main(String[] args)
//	{
//		AdderThread at1=new AdderThread(1, 50);
//		AdderThread at2=new AdderThread(51, 100);
//
//		at1.start();
//		at2.start();
//		
//		try
//		{
//			at1.join();
//			at2.join();
//		}
//		catch(InterruptedException e)
//		{
//			e.printStackTrace();
//		}
//		
//		System.out.println("1~100까지의 합: "+(at1.sm.getNum()+at2.sm.getNum()));
//	}
//}
