class Test11
{
	public static void main(String[] args)
	{
		//마름모 모양 별 찍기

		int h=0,s=0,k=0;

		for(h=0;h<8;h++)
		{
			if(h<4)
			{
				for(k=0;k<3-h;k++)
				{
					System.out.print(" ");
				}
				for(s=0;s<2*h+1;s++)
				{
					System.out.print("*");
				}
			}
			if(h>=4)
			{
				for(k=3;k<h;k++)
				{
					System.out.print(" ");
				}
				for(s=0;s<13-2*h;s++)
				{
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}