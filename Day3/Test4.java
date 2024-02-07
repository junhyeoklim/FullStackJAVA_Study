class Test4
{
	public static void main(String[] args)
	{
		int x=0,y=0,mul=0;

		for(x=1;x<=9;x++)
		{
			for(y=2;y<=9;y++)
			{
				mul = x*y;
				System.out.print(y+"*"+x+"="+mul+"\t");
			}
			System.out.println();
		}
	}
}