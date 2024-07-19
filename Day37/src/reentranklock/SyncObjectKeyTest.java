package reentranklock;

class IHaveTwoNum
{
	int num1=0;
	int num2=0;

	public void addOneNum1() {
		synchronized(key1)
		{
			num1+=1;
		}
	}
	public void addTwoNum1() { 
		synchronized(key1)
		{
			num1+=2;
		}
	}

	public void addOneNum2() { synchronized(key2) {num2 +=1;} }
	public void addTwoNum2() { synchronized(key2) {num2+=2;} }

	public void showAllNums()
	{
		System.out.println("num1: "+num1);
		System.out.println("num2: "+num2);
	}

	Object key1 = new Object();
	Object key2 = new Object();

}

class AccessThread extends Thread
{
	IHaveTwoNum twoNumInst;

	public AccessThread(IHaveTwoNum inst)
	{
		twoNumInst=inst;
	}

	public void run()
	{
		twoNumInst.addOneNum1();
		twoNumInst.addTwoNum1();

		twoNumInst.addOneNum2();
		twoNumInst.addTwoNum2();
	}
}

class SyncObjectKeyTest
{
	public static void main(String[] args)
	{
		IHaveTwoNum numInst=new IHaveTwoNum();

		AccessThread at1=new AccessThread(numInst);
		AccessThread at2=new AccessThread(numInst);

		at1.start();
		at2.start();

		try
		{
			at1.join();
			at2.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		numInst.showAllNums();
	}
}
