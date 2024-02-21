import java.util.Scanner;

/*class Test
{
	public static void main(String[] args)
	{	//1번 문제
		Scanner sc = new Scanner(System.in);
		System.out.println("알파벳 혹은 숫자를 입력 해주세요!");
		String str = sc.nextLine();
		
		char ch = str.charAt(0);

		if(ch >= 'a' && ch <= 'z')
		{
			System.out.println(ch+"는/은 소문자");
		}
		else if(ch >= 'A' && ch <= 'Z')
		{
			System.out.println(ch+"는/은 대문자");
		}
		else if(ch >= '0' && ch <= '9')
		{
			System.out.println(ch+"는/은 숫자");
		}
		else
		{
			System.out.println("입력한 값은 영숫자가 아닙니다.");
		}
	}
}

import java.util.Scanner;

class Test
{
	public static void main(String[] args)
	{
		//2번 문제
		Scanner sc = new Scanner(System.in);
		System.out.println("영문자 하나를 입력 해주세요!");
		String str = sc.nextLine();


		char ch = str.charAt(0);


		if(ch >= 'a' && ch <= 'z')
		{
			System.out.println("대문자로 변환 : "+(char)(ch-32));
		}
		else if(ch >= 'A' && ch <= 'Z')
		{
			System.out.println("소문자로 변환 : "+(char)(ch+32));
		}
		else
		{
			System.out.println("영문자를 입력 해주세요!");
		}

	}
}

//3번 문제 답 : class를 선언 할때 부터 java.lang을 자동으로 import 시키기 때문이다.



class Test
{
	public static void main(String[] args)
	{
		//4번 문제
		double dob = 2.456789;

		System.out.println("소수점 2째 자리까지 표현"+(int)(dob*100)/100F);
	}
}


class Test
{
	public static void main(String[] args)
	{
		//5번 문제
		double dob = 2.456789;		
		
		System.out.println("소수점 세번째 자리에서 반올림 : "+ (int)(dob*100+0.5)/100F);
	}
}

//6번 문제 답 : char형은 2byte 자료형이고 음수 없이 0을 포함하는 양수이기 때문에 0~(2^16-1) 이다.


class Test
{
	public static void main(String[] args)
	{
		//7번 문제
		int apple = 123;
		int bucket = 10;
		int bucketCnt = apple/bucket+(apple%bucket > 0 ? 1:0);

		System.out.println("필요한 총 바구니의 갯수 : "+bucketCnt);		

	}
}

import java.util.Scanner;

class Test
{
	public static void main(String[] args)
	{
		//8번 문제
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력 해주세요!");
		int num = sc.nextInt();

		System.out.println("입력한 숫자는 : "+(num > 0 ? "양수" : (num < 0 ? "음수":"0")));
	}
}

import java.util.Scanner;

class Test
{
	public static void main(String[] args)
	{
		//9번 문제(원리는 생각보다 쉬우니 다시 잘 생각 해보자)
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자를 입력 해주세요!");
		int num = sc.nextInt();

		System.out.println("입력한 숫자에서 가장 가까운 10의 배수에서 입력한 숫자를 뺀 나머지");
		System.out.print(10-num%10);
	}
}


class Test
{
	public static void main(String[] args)
	{
		//10번 문제
		int fah = 232;
		float cel = (int)(5/9F*(fah-32)*100+0.5)/100F;

		System.out.println("화씨를 섭씨로 변환 : "+cel);
	}
}

class Test
{ 
	public static void main(String[] args) 
	{ 
		//11번 문제
		byte a = 10; 
		byte b = 20; 
		byte c = (byte)(a + b); //int 값을 byte 형의 집어 넣어야 하므로 강제로 형 변환을 해줘야 한다
		char ch = 'A'; 
		ch = (char)(ch + 2); //byte c와 비슷한 이유
		float f = 3 / 2F; //float 자료형에는 항상 뒤에 F를 붙일것 
		long l = 3000 * 3000 * 3000L; //float f 와 비슷한 사례
		float f2 = 0.1f; 
		double d = 0.1; 
		boolean result = (float)d==f2; // true를 출력 하고 싶으면 서로 자료형을 맞추면 되니 강제 형 변환 시키면 된다.
		System.out.println("c="+c); 
		System.out.println("ch="+ch); 
		System.out.println("f="+f); 
		System.out.println("l="+l); 
		System.out.println("result="+result); 
	} 
}

//12번 문제 : byte 자료형에 데이터 값 범위는 -128~127 인데 127의 값이 있는 num을 1증가 시켰으므로 오버플로우가 일어나 -128이 출력 된다.
//13번 문제 : byte 자료형에 데이터 값 범위는 -128~127 인데 -128의 값이 있는 num을 1감소 시켰으므로 언더플로우가 일어나 127이 출력 된다.

class Test
{
	public static void main(String[] args)
	{
		//14번 문제 : Math.round 메소드는 소수점 첫째 자리를 반올림 해주는 메소드이다.
		double dob1 = 2.1444;
		double dob2 = 2.1454;

		System.out.println("Ex1 : "+Math.round(dob1));
		System.out.println("Ex2 : "+Math.round(dob2));

	}
}

class Test1
{
	public static void test(int num)
	{
		System.out.println("1번 메소드");
	}
	public static void test(double num)
	{
		System.out.println("2번 메소드");
	}
	public static void test(String num)
	{
		System.out.println("3번 메소드");
	}	
}

public class Test
{
	public static void main(String[] args)
	{
		//15번 문제 : 메소드 오버로딩이란 이름이 같으면서 매개변수 자료형, 개수가 다른 메소드를 뜻 한다
		Test1.test(2);
		Test1.test(2.0);
		Test1.test("안녕");
	}
}


//16번 문제 : java에서 메서드 시그니처는 메서드 명과 파라미터의 순서,타입,개수를 의미한다.
*/
class Test
{
	public static void main(String[] args)
	{
		//17번 문제 : Math.random()메서드는 0이상 1미만 랜덤한 숫자를 발생 시키는 메서드 이다.
		int num = (int)(Math.random()*10);
		System.out.println("0~9까지의 랜덤한 정수 : "+ num);
	}
}

//18번 문제 : 불가능