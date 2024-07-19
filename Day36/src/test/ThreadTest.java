package test;

//class ShowThread extends Thread
//{
//	String threadName;
//	
//	public ShowThread(String name) {
//		threadName = name;
//	}
//	
//	@Override
//	public void run() {
//		
//		for(int i=0; i<100;i++)
//		{
//			System.out.println("안녕하세요. "+threadName+"입니다.");
//			
//			try {
//				sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}

class Increment 
{
	int num;
//	1번 방법
//	public synchronized void increment()
//	{
//		num++;
//	}
//	2번 방법
	public void increment()
	{
		synchronized(this)
		{
			num++;
		}
	}
	public int getNum()
	{
		return num;
	}
}

class IncThread  extends Thread
{
	Increment inc;
	
	public   IncThread(Increment inc) {
		this.inc = inc;
	}
	
	@Override
	public void run() {
		for(int i=0;i<1000;i++)
			for(int j=0;j<1000;j++)
				inc.increment();
	}
}



public class ThreadTest {

	public static void main(String[] args) {

//		1번 문제
//		답 : Thread
		
//		2번 문제
//		답 : 참조 변수는 스택영역에 인스턴스는 힙 영역에, 프로세스
		
//		3번 문제
		
//		ShowThread t1 = new ShowThread("멋진 쓰레드");
//		ShowThread t2 = new ShowThread("예쁜 쓰레드");
//		t1.start();
//		t2.start();
		
//		3-1 : getPriority();
//		3-2 : setPriority();
//		3-3 : Thread.MAX_PRIORITY
//			   Thread.NORM_PRIORITY
//			   Thread.MIN_PRIORITY
		
//		4번 문제
		
		
		
//		5번 문제
//		답 : join();
		
		Increment inc = new Increment();
		IncThread t1 = new IncThread(inc);
		IncThread t2 = new IncThread(inc);
		IncThread t3 = new IncThread(inc);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(inc.getNum());
		
		
	}

}
