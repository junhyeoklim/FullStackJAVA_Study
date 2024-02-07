class Test8
{
	public static void main(String[] args)
	{
		int i=0,j=0,sum=28;

		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				System.out.print(sum-- +"\t");
			}
			System.out.println();
		}
	}
}
/*class Test8
{
	public static void main(String[] args)
	{
		int i=0,j=0,sum=28;

		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				System.out.print(sum+"\t");
				sum -= 1;
			}
			System.out.println();
		}
	}
}*/