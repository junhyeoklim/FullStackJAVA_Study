import java.util.Scanner;
class Testt
{
	//10진수 정수를 전달받아서, 전달받은 정수에 해당하는 2진수를 출력하는 메소드
	public static void main(String[] args)
	{
		int num = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("10진수 입력");
		num = sc.nextInt();

		for(;;)
		{



			if(num/2 == 1)
			{
				System.out.println("테스트2"+num/2);
				break;
			}
			else
				System.out.println("테스트3"+num%2);
			num /= 2;
			System.out.println("테스트1"+num%2);
		}
	}

}