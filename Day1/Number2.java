class Number2
{
	public static void main(String[] args)
	{
		int i = 0, sum = 0;
		for( i = 2; i <= 100; i = i+2)
		{			
		   sum = sum + i;
		   System.out.println("sum = " + sum);
		}
	}
}


/*class Number2
{
	public static void main(String[] args)
	{
		int i = 0, sum = 0;
		for( i = 1; i <= 100; i ++)
		{
		   if(i%2==0)			
		    sum = sum + i;
		   System.out.println("sum = " + sum);
		}
	}
}*/