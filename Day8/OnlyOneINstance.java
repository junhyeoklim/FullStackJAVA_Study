class SimpleNumber
{
	int num=0;
	private static SimpleNumber snInst;
	private SimpleNumber() {}	// 생성자 private 혹시 모를 상황을 대비 하기 위해서 강제로 제한 하는 것
	public void addNum(int n) { num += n; }
	public void showNum() 
	{ 
		System.out.println(num); 
	}
	
	public static SimpleNumber getSimpleNumberInst()
	{
		if(snInst == null) snInst = new SimpleNumber();
		return snInst;
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