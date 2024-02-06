class DoWhile5
{
	public static void main(String[] args)
	{
		int i=1,sum=1;
		do
		{
			sum *= i;
			i++;
		}
		while(i<=5);
		System.out.println("5! : " + sum);
	}
}