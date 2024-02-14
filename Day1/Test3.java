class Test3
{
	public static void main(String[] args)
	{
		int i =0 , sum = 0;

		for(i=1; i<=30; i++)
		{			
			sum = i + sum;
			System.out.println("i = " + i + " sum = "+sum);
		}
		System.out.println(sum);
	}
}