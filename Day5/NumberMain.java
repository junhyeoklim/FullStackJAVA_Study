class Number
{
	int num;

	public void initNum(int n)
	{
		num = n;
	}

	public void printCurrentState()
	{
		System.out.println(num);
	}
}

class NumberMain
{
	public static void main(String[] args)
	{
		Number n1 = new Number();
		n1.initNum(10);
		n1.printCurrentState();

		Number n2 = new Number();
		n2.initNum(20);
		n2.printCurrentState();

	}
}