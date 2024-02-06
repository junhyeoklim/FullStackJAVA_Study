class DoWhile3
{
	public static void main(String[] args)
	{
		int i=4,cnt=0;
		do
		{
			cnt++;
			i += 4;
		}
		while(i<=100);
		System.out.println("4의 배수의 갯수 : " + cnt);
	}
}