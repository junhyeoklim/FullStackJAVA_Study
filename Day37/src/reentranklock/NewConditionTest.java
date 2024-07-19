package reentranklock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class InputString
{
	String str;
	boolean newCheck;

	ReentrantLock key = new ReentrantLock();
	Condition write = key.newCondition();
	Condition read = key.newCondition();
	int cnt;
	
	public void setString(String str)
	{
		
		key.lock();
		try {

			if(newCheck == true)
			{
				System.out.println("테스트2");
//				write.await();
			}
			this.str = str;
			newCheck = true;
			System.out.println((++cnt)+"테스트");
			//다른 쓰레드를 깨우는것 -> 여기선 Reader
			write.signal();
		} //catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		finally
		{
			key.unlock();
		}
	}

	public String getString()
	{ 
		String retStr =null;
		key.lock();
		try {
			if(newCheck == false)
				write.await();
			retStr = str;
			newCheck = false;
			read.signal();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			key.unlock();
		}
		return retStr;
	}
}

class Writer extends Thread
{
	InputString istr;

	public Writer(InputString istr) {
		this.istr = istr;
	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		String str;
		for(int i=0;i<5;i++)
		{
			str = sc.nextLine();
			istr.setString(str);

		}
		sc.close();
	}
}

class Reader extends Thread 
{
	InputString istr;

	public Reader(InputString istr) {
		this.istr = istr;
	}	

	@Override
	public void run() {
		for(int i=0;i<5; i++)
			System.out.println("read string : "+istr.getString());
	}
}

public class NewConditionTest {

	public static void main(String[] args) {

		InputString str = new InputString();
		
		Writer wt = new Writer(str);
		Reader rd = new Reader(str);


		rd.start();
		wt.start();

	}

}
