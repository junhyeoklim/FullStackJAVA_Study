class Test3
{
	public static void main(String[] args)
	{
		int x=0,y=0,mul=0;

		for(x=2;x<=9;x++)
		{
			System.out.println(x+"단");

			for(y=1;y<=9;y++)
			{
				mul = x*y;
				System.out.println(x+"*"+y+"="+mul);
			}

			System.out.println();
		}

	}
}