class SimpleNumber
{
	int num=0;
	private static SimpleNumber sln;
	private SimpleNumber() {}	// 생성자 private
	public void addNum(int n) { num += n; }
	public void showNum() 
	{ 
		System.out.println(num); 
	}
	
	public static SimpleNumber getSimpleNumberInst()
	{
		if(sln == null) sln = new SimpleNumber();
		return sln;
	}
}

class OnlyOneINstance
{
	public static void main(String[] args)
	{
		SimpleNumber num1 = SimpleNumber.getSimpleNumberInst();
		num1.addNum(20);

		SimpleNumber num2 = SimpleNumber.getSimpleNumberInst();
		num2.addNum(30);

		num1.showNum();
		num2.showNum();
	}
}