/*class Test6
{
	public static void main(String[] args)
	{
		int a=0,b=0;

		for(a=0;a<=9;a++)
		{
			for(b=0;b<=9;b++)
			{
				if((a*10+b)+(b*10+a) == 99)
					System.out.println(""+a+b +" + "+ b + a +" = 99");
			}
		}
	}
}*/
class Test6
{
	public static void main(String[] args)
	{
		int a=0,b=0;

		for(a=0;a<=9;a++)
		{
			for(b=0;b<=9;b++)
			{

				if(a+b == 9 && b+a ==9)
					System.out.println(a+""+b +" + "+ b + a +" = "+(a+b)+(b+a));
			}
		}
	}
}