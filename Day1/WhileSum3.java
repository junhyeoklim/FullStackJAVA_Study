class WhileSum3
{
	public static void main(String[] args)
	{
		int i = 4, cnt=0;
		while(i<=100)
		{
			cnt = cnt + 1;	
			i =  i+4;
		}
		System.out.println("4의 배수의 갯수 : " + cnt);
	}
}