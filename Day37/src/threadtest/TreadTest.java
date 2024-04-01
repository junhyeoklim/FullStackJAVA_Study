package threadtest;

import java.util.Scanner;

//class ProcessThread extends Thread
//{
//	String name;
//	
//	public ProcessThread(String name) {
//		this.name = name;
//	}
//	
//	@Override
//	public void run() {
//		for(int i=0;i<100;i++)
//		{
//			System.out.println(name);
//			try {
//				sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//}

//class Sum
//{
//	int num;
//	
//	public Sum() {
//		num = 0;
//	}
//	
//	public int getSum()
//	{
//		return num;
//	}
//	
//	public void addNum(int num)
//	{
//		this.num += num;
//	}
//}

//class AddThread extends Thread
//{
//	int num;
//	int num1,num2;
////	Sum sm = new Sum();
//	
//		public AddThread(int num1,int num2) {
//			num = 0;
//			this.num1 = num1;
//			this.num2 = num2;
//		}
//
//		@Override
//		public void run() {
//			for(int i = num1; i<=num2; i++)
//				addNum(i);		
//			}
//		
//		public void addNum(int n)
//		{
//			num += n;
//		}
//		
//		public int getNum()
//		{
//			return num;
//		}
//}


class InputNum
{
	int num = 0;
	boolean newNum = false;
	
	public void setNum(int num)
	{
		synchronized (this) {
			if(newNum == true)
			{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.num = num;
			newNum = true;
			notify();
		}		
	}
	
	public int getNum()
	{
		synchronized (this) {
			if(newNum == false)
			{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			newNum = false;
			notify();
			return num;
		}
	}
}

class InputnumSummer extends Thread
{
	InputNum inum;
	int sum;
	
	public InputnumSummer(InputNum inum) {
		this.inum = inum;
	}
	
	@Override
	public void run() {
		for(int i=0;i<5;i++)
			sum += inum.getNum();
		System.out.println("입력된 정수의 총 합 : "+sum);
	}
}



public class TreadTest {

	public static void main(String[] args) {

//		1번 문제
//		답 : 운영체제
		
//		2번 문제
//		답 : 메소드 영역, 스택 영역, 힙 영역 , 프로세스
		
//		3번 문제
		
//		ProcessThread thread = new ProcessThread("멋진 쓰레드");
//		ProcessThread thread2 = new ProcessThread("예쁜 쓰레드");
//		
//		thread.start();
//		thread2.start();
		
		
//		4번 문제
		
//		AddThread th1 = new AddThread(1, 50);
//		AddThread th2 = new AddThread(51, 100);
//		
//		Thread tr1 = new Thread(th1);
//		Thread tr2 = new Thread(th2);
//		
//		tr1.start();
//		tr2.start();
//		
//		try {
//			tr1.join();
//			tr2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		System.out.println(th1.getSum()+"\t" + th2.getSum());
		
		
//		5번 문제
//		답 : join();
		
//		AddThread th1 = new AddThread(1, 50);
//		AddThread th2 = new AddThread(51, 100);
//		
//		th1.start();
//		th2.start();
//		
//		try {
//			th1.join();
//			th2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(th1.getNum()+"\t" + th2.getNum());
	
		InputNum inum = new InputNum();
		InputnumSummer sum = new InputnumSummer(inum);
		sum.start();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("총 5개의 정수 입력");
		for(int i=0;i<5;i++)
			inum.setNum(sc.nextInt());
		
		try {
			sum.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		
	}

}
