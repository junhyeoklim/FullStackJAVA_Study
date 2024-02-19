class Excercise1
{
	public static void main(String[] args)
	{
		//p.111 1번문제
		int sum = 0;
		
		for(int i =1; i<=100;i++)
		{
			if(i%5 == 0)
				sum +=i;
		}

		System.out.println("5의 배수의 합계는 "+sum);
	}
}