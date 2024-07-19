package reentranklock;


class TestThread extends Thread
{
	String str;
	
	public TestThread(String str) {
		this.str = str;
	}
	
	@Override
	public void run() {
		for(int i=0; i<100; i++)
		{
			System.out.println(str);
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


public class RRRRRReTest {

	public static void main(String[] args) {
		
//		1번 문제
//		답 : 운영체제
		
//		2번 문제
//		답 : 메서드 영역,스택 영역,힙 영역,프로세스
		
//		3번 문제
		
		TestThread t1 = new TestThread("멋진 쓰레드");
		TestThread t2 = new TestThread("예쁜 쓰레드");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
