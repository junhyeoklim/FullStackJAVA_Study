import java.util.Scanner;

class Test
{
	public static void main(String[] args)
	{
		int num1 =0, num2 =0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫 번째 숫자를 입력하세요.");
		num1 = sc.nextInt();
		System.out.println("두 번째 숫자를 입력하세요.");
		num2 = sc.nextInt();
		System.out.println("당신이 입력한 두 수는  "+num1+"와/과 "+num2+"입니다." );
	}
}