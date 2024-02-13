class Test5
{
	// 10번 문제,11번 문제 
	public static boolean test5(int num1)
	{
		int i =0;

		if(num1<=1)
		 return false;

		for(i=2;i<num1;i++)
		{
			if(num1%i == 0)
			{				
				return false;
			}
		}
		return true;		
	}

	public static void main(String[] args)
	{
		int i =0;
		for(i=1;i<=100;i++)
		{
			if(test5(i))
				System.out.println(i);
		}
	}
}

/*class Test5
{
	public static void test5(int num1)
	{
		int i =0;
		String check = null;
		for(i=2;i<num1;i++)
		{
			if(num1%i == 0)
			{				
				break;
			}
		}
		if(num1 == i)
			System.out.println("true");
		else if(num1 != i)
			System.out.println("false");
	}

	public static void main(String[] args)
	{
		test5(7);
	}
}*/
/*class Test5
{
	public static int test5(int num1)
	{
		int i =0,mul=1;		
		for(i=1;i<=num1;i++)
		{
			mul *= i;
		}
		return mul;
	}

	public static void main(String[] args)
	{
		System.out.println(test5(5));
	}
}*/