class WhileSum
{
	public static void main(String[] args)
	{
		int i = 0, sum=0;
		while(i<=100)
		{
			sum = sum + i;
			System.out.println("sum = "+sum);
			i =  i+1;
		}
	}
}