class DoWhile4
{
	public static void main(String[] args)
	{
		int i=7,sum=0,cnt=0;
		do
		{
			sum += i;
			cnt++;
			System.out.println("7의 배수 : " + i + "  "+"sum의 값 : "+sum+ "  " + cnt+"번째 항");
			i += 7;
		}
		while(sum<=1000);	
	}
}
/*class DoWhile4 -> if문 사용
{
	public static void main(String[] args)
	{
		int i=7,sum=0,cnt=0;
		do
		{
			sum += i;
			cnt++;
			if(sum >= 1000)
			 System.out.println("최초의 수 : " + i + " " + cnt+"번째 항");
			i += 7;
		}
		while(sum<=1000);
	}
}*/



/*class DoWhile4 -> 반복문 밖에서 출력
{
	public static void main(String[] args)
	{
		int i=7,sum=0,cnt=0;
		do
		{
			sum += i;
			cnt++;
			i += 7;
		}
		while(sum<=1000);
		System.out.println("최초의 수 : " + (i-7) + " " + cnt+"번째 항"); -> i값을 한번 더 뺀 이유는 i값이 1번 더 증가 된 이후 조건을 만나기 떄문
	}
}*/