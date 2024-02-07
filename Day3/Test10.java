class Test10
{
	public static void main(String[] args)
	{
		int h=0,s=0,k=0;

		for(h=0;h<4;h++)
		{
			for(k=0;k<h;k++)
			{
				System.out.print(" ");
			}
			for(s=0;s<7-2*h;s++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}