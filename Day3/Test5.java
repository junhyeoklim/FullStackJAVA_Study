class Test5
{
	public static void main(String[] args)
	{
		int x=0,y=0,mul=0;

		for(x=2;x<=9;x++)
		{
			for(y=1;y<=x;y++)
			{
				mul = x*y;
				System.out.println(x+"*"+y+"="+mul);
			}
			System.out.println();
		}
	}
}