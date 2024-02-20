/*
import java.util.Scanner;

class Check
{
	static char ch;
	public static char check(String str)
	{
		ch = str.charAt(0);
		return ch;
	}	
}


class Test
{
	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		String str = null;

		System.out.println("입력 해주세요!");
		str = sc.nextLine();


		if(Check.check(str) >= '0' && Check.check(str) <= '9')
		{
			System.out.println(str+"은/는 숫자");
		}
		else if(Check.check(str) >= 'a' && Check.check(str) <= 'z')
		{
			System.out.println(str+"은/는 소문자");
		}
		else if(Check.check(str) >= 'A' && Check.check(str) <= 'Z')
		{
			System.out.println(str+" 은/는 대문자");
		}
		else
		{
			System.out.println("입력한 값은 영문,숫자가 아닙니다.");
		}
	}
}*/

import java.util.Scanner;

class Check
{
	static char ch;
	public static char check(String str)
	{
		ch = str.charAt(0);
		return ch;
	}	
}
class Test
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str = null;


		System.out.println("영문자 하나를 입력 해주세요!");
		str = sc.nextLine();

		if(Check.check(str) >= 'a' && Check.check(str) <= 'z')
		{
			System.out.println("대문자로 변환 : "+str.toUpperCase());
		}
		else if(Check.check(str) >= 'A' && Check.check(str) <= 'Z')
		{
			System.out.println("소문자로 변환 : "+str.toLowerCase());
		}
		else
		{
			System.out.println("영문자를 입력 해주세요!");
		}
	}
}