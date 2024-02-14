class ContinueTest
{
	public static void main(String[] args)
	{
		int i =0;
		for(i=1;i<=20;i++)
		{
			if(i%2==0) continue;
			else if(i%3==0) continue;

			System.out.println("i의 값 : " + i);
		}
	}
}