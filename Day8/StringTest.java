import java.util.Scanner;

class StringTest
{
	public static void main(String[] args)
	{
		/*//1번 문제
		Scanner sc =new Scanner(System.in);
		String str = null;

		System.out.println("문자열을 입력 해주세요!");
		str = sc.nextLine();

		System.out.println("입력한 문자열의 갯수 : " + str.length());
		

		//2번 문제
		Scanner sc = new Scanner(System.in);

		String str1 = null;
		String str2 = null;

		System.out.println("첫 번째 문자열을 입력 해주세요!");
		str1 = sc.nextLine();
		System.out.println("두 번째 문자열을 입력 해주세요!");
		str2 = sc.nextLine();

		System.out.println(str1.concat(str2));
		


		//3번 문제
		Scanner sc = new Scanner(System.in);

		String str = null;

		System.out.println("대문자를 입력 해주세요!");
		str = sc.nextLine();


		System.out.println(str.toLowerCase());
		


		//4번 문제
		Scanner sc = new Scanner(System.in);

		String str = null;

		System.out.println("소문자를 입력 해주세요!");
		str = sc.nextLine();


		System.out.println(str.toUpperCase());
		*/


		//5번 문제(임의의 문자열 5개를 입력받아 알파벳 순으로 정렬)
		Scanner sc = new Scanner(System.in);

		String str1 = null;
		String str2 = null;
		String str3 = null;
		String str4 = null;
		String str5 = null;
		String temp = null;		


		System.out.println("첫 번째 문자열을 입력 해주세요!");
		str1 = sc.nextLine();
		System.out.println("두 번째 문자열을 입력 해주세요!");
		str2 = sc.nextLine();
		System.out.println("세 번째 문자열을 입력 해주세요!");
		str3 = sc.nextLine();
		System.out.println("네 번째 문자열을 입력 해주세요!");
		str4 = sc.nextLine();
		System.out.println("다섯 번째 문자열을 입력 해주세요!");
		str5 = sc.nextLine();


		if(str1.compareTo(str2) > 0)
		{
			temp = str1;
			str1 = str2;
			str2 = temp;
		}
		if(str1.compareTo(str3) > 0)
		{
			temp = str1;
			str1 = str3;
			str3 = temp;
		}			
		if(str1.compareTo(str4) > 0)
		{
			temp = str1;
			str1 = str4;
			str4 = temp;
		}
		if(str1.compareTo(str5) > 0)
		{
			temp = str1;
			str1 = str5;
			str5 = temp;
		}
		if(str2.compareTo(str3) > 0)
		{
			temp = str2;
			str2 = str3;
			str3 = temp;
		}			
		if(str2.compareTo(str4) > 0)
		{
			temp = str2;
			str2 = str4;
			str4 = temp;
		}
		if(str2.compareTo(str5) > 0)
		{
			temp = str2;
			str2 = str5;
			str5 = temp;
		}
		if(str3.compareTo(str4) > 0)
		{
			temp = str3;
			str3 = str4;
			str4 = temp;
		}
		if(str3.compareTo(str5) > 0)
		{
			temp = str3;
			str3 = str5;
			str5 = temp;
		}
		if(str4.compareTo(str5) > 0)
		{
			temp = str4;
			str4 = str5;
			str5 = temp;
		}		
		System.out.println(str1+" "+str2+" "+str3+" "+str4+" "+str5);
	}
}