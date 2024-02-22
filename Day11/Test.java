import java.util.Scanner;

/*class Test
{
	public static void main(String[] args)
	{
		String source="1 5 7";
		Scanner sc=new Scanner(source); 
		
		int num1=sc.nextInt();//공백을 기준으로 좌측에 있는 수를 집어 넣는다. 1
		int num2=sc.nextInt();//공백을 기준으로 좌측에 있는 수를 집어 넣는다. 5
		int num3=sc.nextInt();//공백을 기준으로 좌측에 있는 수를 집어 넣는다. 7
		int sum=num1+num2+num3;
		
		System.out.printf(
			"문자열에 저장된 %d, %d, %d의 합은 %d \n", 
			num1, num2,num3, sum);
	}
}*/

class Test
{
	public static void main(String[] args)
	{
		//구구단 출력

		for(int x=1; x<=9;x++)
		{
			for(int y=2; y<=9;y++)
			{
				System.out.printf("%d*%d=%d\t",y,x,(x*y));
			}
			System.out.printf("\n");
		}
	}
}