/*
	0.  참조형 변수의 자료형의 크기는?
	답 : 4byte

	1. 다음 중 형변환을 생략할 수 있는 것은? (모두 고르시오)
	byte b = 10; 
	char ch = 'A'; 
	int i = 100; 
	long l = 1000L;
	a. b = (byte)i; 
	b. ch = (char)b; 
	c. short s = (short)ch; 
	d. float f = (float)l; 
	e. i = (int)ch;

	답: a,d,e

	2.  char 타입의 변수에 저장될 수 있는 정수 값의 범위는?
	0~2^16-1

	3.  자바 기본 자료형의 자동 형변환 규칙은?

	명시적 형 변환,묵시적 형 변환이 있다

import java.util.Scanner;
	
class Test
{
	public static void main(String[] args)
	{
		//4. 영어 대문자, 소문자를 각각 출력하고 그에 해당하는 아스키 코드도 같이 출력하시오.
		Scanner sc = new Scanner(System.in);
		char alp1 = 'A';
		char alp2 = 'a';

		System.out.println("입력한 대문자 :" + alp1+" 아스키 코드 : " + (int)alp1);
		System.out.println("입력한 소문자 :" + alp2+" 아스키 코드 : " + (int)alp2);

	}
}	

import java.util.Scanner;

class Test
{
	public static void main(String[] args)
	{
		//5. 임의의 문자열을 입력받아 문자열의 갯수 세기
		Scanner sc = new Scanner(System.in);
		String str1 = null;

		System.out.println("문자열을 입력 해주세요!");
		str1 = sc.nextLine();

		System.out.println("입력한 문자열의 갯수 : "+str1.length());
	}
}

import java.util.Scanner;

class Test
{
	public static void main(String[] args)
	{
		//6. 임의의 문자열 두개를 입력받아 두 문자열 합치기
		Scanner sc = new Scanner(System.in);
		String str1 = null;
		String str2 = null;

		System.out.println("첫 번째 문자열을 입력 해주세요!");
		str1 = sc.nextLine();
		System.out.println("두 번째 문자열을 입력 해주세요!");
		str2 = sc.nextLine();

		System.out.println("입력한 문자열 합치기 : "+str1.concat(str2));
	}
}

import java.util.Scanner;

class Test
{
	public static void main(String[] args)
	{
		//7. 임의의 문자열을 입력받아 문자열을 소문자로 바꾸기
		Scanner sc = new Scanner(System.in);
		String str1 = null;

		System.out.println("대문자를 입력 해주세요!");
		str1 = sc.nextLine();

		System.out.println("소문자로 바꾸기 : "+str1.toLowerCase());
	}
}	

import java.util.Scanner;

class Test
{
	public static void main(String[] args)
	{
		//8. 임의의 문자열을 입력받아 문자열을 대문자로 바꾸기
		Scanner sc = new Scanner(System.in);
		String str1 = null;

		System.out.println("소문자를 입력 해주세요!");
		str1 = sc.nextLine();

		System.out.println("대문자로 바꾸기 : "+str1.toUpperCase());
	}
}
	
*/

import java.util.Scanner;

class Test
{
	public static void main(String[] args)
	{
		//9. 임의의 문자열 5개를 입력받아 알파벳 순으로 정렬
		Scanner sc = new Scanner(System.in);
		String str1 = null;
		String str2 = null;
		String str3 = null;
		String str4 = null;
		String str5 = null;
		String temp = null;

		System.out.println("첫 번째 문자를 입력 해주세요!");
		str1 = sc.nextLine();
		System.out.println("두 번째 문자를 입력 해주세요!");
		str2 = sc.nextLine();
		System.out.println("세 번째 문자를 입력 해주세요!");
		str3 = sc.nextLine();
		System.out.println("네 번째 문자를 입력 해주세요!");
		str4 = sc.nextLine();
		System.out.println("다섯 번째 문자를 입력 해주세요!");
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

		System.out.println("알파벳 순으로 정렬 : " + str1 +" "+ str2 +" "+ str3 +" "+ str4 +" "+ str5);


	}
}

	


	