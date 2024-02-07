class Test7
{
	public static void main(String[] args)
	{
		int i=0,j=0,sum=1;

		for(i=0;i<5;i++)
		{
			for(j=0;j<5;j++)
			{
				System.out.print(sum++ +"\t");
			}
			System.out.println();
		}
	}
}