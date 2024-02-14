class BreakTest2
{
	public static void main(String[] args)
	{

		for(int i=1; true;i++)
		{
			if(i%5 == 0)
			{
				if(i%7 == 0)
				{
					System.out.println("5의 배수이자 7의 배수인 가장 작은 수 : " + i);
				 	break;

				}
			}
		}
	}
}


/*class BreakTest2
{
	public static void main(String[] args)
	{
		for(int i=1; true;i++)
		{
			if(i%5==0 && i%7==0)
			{
				System.out.println("5의 배수이자 7의 배수인 가장 작은 수 : " + i);
			 	break;
			}
		}
	}
}*/