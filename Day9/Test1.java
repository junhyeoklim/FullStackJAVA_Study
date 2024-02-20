import java.util.Scanner;
/*
class Test1
{
	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);

		System.out.println("!!숫자를 입력 해주세요!!"); 
		char ch = (char)sc.nextInt();

		if(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
		{
			System.out.println(ch); 

		}
		else
		{
			System.out.println("숫자를 다시 입력 해주세요!");
		}
	}
}
*/
class Test1
{
	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);

		System.out.println("!!알파벳을 입력 해주세요!!"); 
		char ch = sc.nextLine().charAt(0);


		if(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
		{
			System.out.println((int)ch); 

		}
		else
		{
			System.out.println("다시 입력 해주세요!");
		}
	}
}