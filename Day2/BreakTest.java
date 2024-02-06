class BreakTest
{
	public static void main(String[] args)
	{
		int i =0,sum=0;
		for(i=1;true;i++)
		{
			sum += i;
			if(sum >= 5000)
			{
			  System.out.println("i의 값 : " + i + " " + "sum의 값 : " + sum);
			  break;
			}
		}
	}
}