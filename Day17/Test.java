import java.util.Scanner;

class Test
{
	public static void main(String[] args)
	{
		//1번문제
		Scanner sc = new Scanner(System.in,"EUC-KR");

		System.out.println("16진수 문자열을 입력 해주세요!");
		String str = sc.nextLine();

		checkNum(str);
	

		/*
		//2번 문제
		String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--"
				,"-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

		Scanner sc = new Scanner(System.in,"EUC-KR");
		System.out.println("문자열을 입력 해주세요!");
		String str = sc.nextLine();

		for(int i =0; i<str.length();i++)
		{
			System.out.print(str.charAt(i)-'A'+"\t");
		}
		*/
	}



	
	public static void checkNum(String str)
	{

		int[] num = new int[str.length()];


		for(int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);

			if(ch >= 'A' && ch <= 'F')
				num[i] = 10+(ch-'A');
			else if(ch >= 'a' && ch <= 'f')
				num[i] = 10+(ch-'a');
			else if(ch >= '0' && ch <= '9')
				num[i] = (ch-'0');
			else
			{
				System.out.println("16진수가 아닙니다!");
				break;
			}
		}

		for(int i=0; i<str.length();i++)
		{
			System.out.print(Integer.toBinaryString(num[i]));
		}
		

	}
	
}