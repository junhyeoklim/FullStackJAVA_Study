import java.util.Scanner;

class ScannerTest
{
	public static void main(String[] args)
	{
		int num1 =0, num2 =0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫 번째 숫자를 입력하세요.");
		num1 = sc.nextInt();
		System.out.println("두 번째 숫자를 입력하세요.");
		num2 = sc.nextInt();
		
		if(num1 > num2)
		 System.out.println("가장 큰 수는 "+num1+"입니다." );
		else if(num1 < num2)
		 System.out.println("가장 큰 수는 "+num2+"입니다." );
		else
		 System.out.println("두 수가 서로 같습니다.");
	}
}