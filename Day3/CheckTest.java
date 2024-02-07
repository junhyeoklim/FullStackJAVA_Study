import java.util.Scanner;

class CheckTest
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int user = 0,i=0;

			System.out.println("소수 판별하기!");
			System.out.println("숫자를 입력 해주세요!");
			user = sc.nextInt();
		for(i=2; i<user;i++)
		{
			if(user%i ==0) break;
		}
		if(user == i)
			System.out.println(user+"은/는 소수");
		else
			System.out.println(user+"은/는 소수가 아님");
	} 
}
/*class CheckTest --> 제대로 동작 안 함 (121을 소수라고 판단 하는 오류 있음)
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int user = 0;

			System.out.println("소수 판별하기!");

		for(;;)
		{
			System.out.println("숫자를 입력 해주세요!");
			user = sc.nextInt();

			if(user <=1)
			{
				System.out.println("소수가 아닙니다!");
			}
			else if(user <=10 && user > 1)
			{
				if(user==2 || user==3 || user==5 || user==7)
				{
				  	System.out.println("정답입니다!");
					break;
				}
				else
				{
					System.out.println("소수가 아닙니다!");
				}
			}
			else if(user >10)
			{
				if(user%2==0 || user%3==0 || user%5==0 || user%7==0)
				 	System.out.println("소수가 아닙니다!");
				else
				{
				  	System.out.println("정답입니다!");
					break;
				}
			}
		}
	} 
}*/
