class WhileSum4
{
	public static void main(String[] args)
	{
		int i = 7, sum=0,cnt=0;
		while(sum<=1000)
		{

			sum = sum + i;	
			cnt = cnt+1;
			System.out.println("7의 배수 : " + i + " "+"sum : "+sum+" " +cnt +"번째 항");
			i =  i+7;
		}
			System.out.println("7의 배수 : " + (i-7) + " "+"sum : "+sum+" " +cnt +"번째 항");		
	}
}