class Number
{
	public int num1;
	public static int num2;

	Number()
	{
		num1++;
		num2++;
	}

	public void printNumber()
	{
		System.out.println(num1 + " " + num2);
	}

}

class NumberMain
{
	public static void main(String[] args)
	{
		Number n1 = new Number();
		Number n2 = new Number();
		Number n3 = new Number();

		System.out.println(n1.num1);
		n1.printNumber();
		n2.printNumber();
		System.out.println(n2.num1);
		n3.printNumber();
		System.out.println(n3.num1);
	}

}