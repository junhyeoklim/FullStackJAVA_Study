import java.util.Scanner;

class Test
{

	public static void main(String[] args)
	{
		/*//1번 문제
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자를 입력 해주세요.");
		int num = sc.nextInt();

		if(num >= 97 && num <= 113  || num >= 65 && num <= 91)
		{
			System.out.println((char)num);
		}
		else
		 System.out.println("다른 숫자를 입력 해주세요!");
		*/
		/*//2번 문제

		Scanner sc = new Scanner(System.in);
		String str = "";

		System.out.println("알파벳을 입력 해주세요!");
		str = sc.nextLine();
		char ch = str.charAt(0);

		if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
			System.out.println((int)ch);
		else
			System.out.println("알파벳을 입력 해주세요!");
		*/
		/*//3번 문제
		String str1 = "ABCDEFGHIJKLMN"; //역순
		String str2 = "990208-1012752"; // 중간에 삽입된 -를 삭제

		StringBuilder strb1 = new StringBuilder(str1);
		StringBuilder strb2 = new StringBuilder(str2);


		System.out.println("역순으로 출력 : "+ strb1.reverse());
		System.out.println("-삭제 : "+ strb2.deleteCharAt(str2.indexOf("-")));
		*/

		/*//4번 문제

		for(int i =0; i<3; i++){
		
			for(int j =1; j<=3; j++){
				for(int k=2+3*i; k<=4+3*i; k++){
					if(k<10)
						System.out.print(k+"*"+j+"="+(j*k)+"\t");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}*/


		/*//5번 문제
		int sum = 0;

		for(int j=1; j<=10; j++)
		{
			for(int i = 1; i <=j; i++)
			{
				sum += i;	
			}
		}
			System.out.println(sum);
		*/


		/*//6번 문제

		int num = 1,sum = 0;
		
		for(;;)
		{


			if(num%2 ==0)
			{
				sum -= num;
			}
			else
				sum += num;
			num++;			
			if(sum >= 100)
			{
				System.out.println("sum="+sum+"\t숫자 : "+num);
				break;
			}
		
			
		}*/





		/*//7번 문제
		String str = "12345";
		int num = 0;
		int sum = 0;

		for(int i = 0; i <str.length(); i++)
		{
			num = str.charAt(i)-48;
			sum = sum+num%10;
		}
		System.out.println(sum);
		*/

		/*//8번 문제

		int num1 = 12345;
		int sum = 0;
		int num2 = num1;
		while(num2/10 >0)
		{
			num2 = num1;
			
			sum = sum + num1%10;
			num1/=10;
			System.out.println(num1);
		}
		System.out.println(sum);
		*/


		/*//9번 문제
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;

		for(int i =0;i<10;i++ )
		{
			num3 = num1+num2;

			num1 = num2;
			num2 = num3;
		}
		System.out.println(num3);
		*/


		/*//11번 문제
		Scanner sc = new Scanner(System.in);

		System.out.println("문자열을 입력 해주세요!");
		String str = sc.nextLine();
		boolean flag = true;
		char ch = ' ';

		for(int i =0; i < str.length(); i++)
		{
			ch = str.charAt(i);

			if(!(ch >= '0' && ch <= '9'))
			{
				flag = false;
				break;
			}
		}
		if(flag)
			System.out.println("입력한 문자열은 숫자입니다.");
		else
			System.out.println("입력한 문자열은 숫자가 아닙니다.");
		*/

		/*//12번 문제

		int num1 = 12321;
		int temp = num1;
		int origin = num1;
		int check = 0;

		while(temp/10 > 0)
		{
			temp = num1;
			check = check*10 + num1%10;
			num1 /= 10;			
		}

		if(check == origin)
			System.out.println("입력한 수는 회문수가 맞습니다");
		else
			System.out.println("입력한 수는 회문수가 아닙니다");
		

		//13번 문제 : int 형 정수 5를 문자열로 바꾸는 메소드는?
		답 : (String타입 참조 변수).valueOf(5);

		
		//14번 문제 : 문자열 "5"를 정수 5로 바꾸는 메소드는?
		답 :  Integer.parseInt("5");

		//15번 문제
		답 : 첫 번째는 String 메소드인 compareTo 메소드를 이용하여 
		     반환값이 0 이외에 값이 나오면 다른 문자라는 조건문을 작성 하는 방법이고,
		     두 번째는 조건문을 사용하여 서로 같은지 비교 한다.
		*/
	}

}