class WhileSum5
{
	public static void main(String[] args)
	{
		int i = 1, sum=1;
		while(i<=5)
		{
			sum = sum * i;	
			i =  i+1;
		}
		System.out.println("5! :  " + sum);
	}
}