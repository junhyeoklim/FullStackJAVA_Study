import java.util.Scanner;

class AgeInputException extends Exception
{
	//8번 문제
	public AgeInputException()
	{
		super("유효하지 않은 나이가 입력되었습니다.");
	}

}


class Test
{
	/*public static void main(String[] args) throws AgeInputException
	{
		Scanner keyboard=new Scanner(System.in);

		//1번 문제
		try
		{
			System.out.println("숫자를 입력 하세요");
			int num1 = sc.nextInt();
			sc.nextLine();

			System.out.println("제수를 입력 하세요");
			int num2 = sc.nextInt();
			sc.nextLine();

			System.out.println("결과 값 : "+(num1/num2));
		}
		catch(Exception e)
		{
			System.out.println("0으로 나눌 수 없습니다.");
		}


		//2번 문제
		답 : Throwable

		//3번 문제
		답 : 1. IndexOutOfBoundsException
		      2. IllegalArgumentException
		      3. NegativeArraySizeException
		      4. NullPointerException


		//4번 문제

		//5번 문제 
		int[] arr=new int[100];
		
		for(int i=0; i<3; i++)
		{
			try{
			System.out.print("피제수 입력: ");
			int num1=keyboard.nextInt();
			
			System.out.print("제수 입력: ");
			int num2=keyboard.nextInt();

			System.out.print("연산결과를 저장할 배열의 인덱스 입력: ");
			int idx=keyboard.nextInt();
			arr[idx]=num1/num2;

			System.out.println("나눗셈 결과는 "+arr[idx]);
			System.out.println("저장된 위치의 인덱스는 "+idx);
			}
			catch(ArithmeticException e){		

				System.out.println("제수는 0이 될 수 없습니다.");
				i-=1;
			}
			catch(IndexOutOfBoundsException e){
				System.out.println("유효하지 않은 인덱스 값입니다.");
				i-=1;
			}							
		}


		//6번 문제
		답 : Throwable은 모든 예외 처리에 최상위 클래스 이므로 ArithmeticException을 포함하고 있는데
		     밑에서 한번 더 ArithmeticException을 중복 호출 하게 되서 컴파일 에러가 뜬다.



		//7번 문제
		답 : finally
		
		//9번 문제
		답 : throw
	
		//10번 문제*/
	public static void main(String[] args) throws AgeInputException
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요: ");
		try{
			int age= sc.nextInt();
			sc.nextLine();

			if(age<0)
			{
				AgeInputException excpt=new AgeInputException();
				throw excpt;
			}
			System.out.println("당신은 "+age+"세입니다.");
		}
		catch(AgeInputException e)
		{
			System.out.println(e.getMessage());
		}
	


		/*
		//11번 문제
		답 : main메소드내에서도 예외 상황을 처리하지 않는다는 말은 catch를 하지 않겠다와 같은 의미로
			thorws를 명시적으로 해주면 된다

		//12번 문제
		답 : 1. getMessage 메소드를 호출한다.
		     2. 예외상황이 발생해서 전달되는 과정을 출력해준다.
  		     3. 프로그램을 종료한다.

		//13번 문제
		답 : Throwable,printStackTrace;




		//15번 문제
		답 : Exception,Error,Error,Error,VirtualMachineError,Error

		//16번 문제
		답 : RunTimeException,Other Exceptions

		//17번 문제
		답 : checked 클래스인지 unchecked 클래스인지

		//18번 문제
		답 : throws CloneNotSupportedException을 명시하지 않아서 오류가 났다


		//19번 문제
		답 : RunTimeException

		//20번 문제
		답 : 대표적으로 NullPointerException, IndexOutOfBoundsException, IllegalArgumentException
		     , NegativeArraySizeException 등이 있다
		*/
	}
}





/*
		//14번 문제
class NameSizeException extends Exception
{
	private String wrongName;

	public NameSizeException(String name)
	{
		super("유효하지 않은 이름 크기 입니다.");
		wrongName = name;
	}

	public void showWrongName()
	{
		System.out.println("잘못 입력된 이름 : "+wrongName);
	}
}

class NegativeAgeException extends Exception
{
	public NegativeAgeException()
	{
		super("유효하지 않은 범위 입니다.");
	}
}

class PersonalInfo
{
	String name;
	int age;

	public PersonalInfo(String name, int age)
	{
		this.name=name;
		this.age=age;
	}
	public void showPersonalInfo()
	{
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
	}
}

class Test
{
	private static Scanner sc = new Scanner(System.in,"EUC-KR");

	public static void main(String[] args)
	{
		try{
			PersonalInfo readInfo = readPersonalInfo();
			readInfo.showPersonalInfo();
			
		}
		catch(NameSizeException e){
			e.showWrongName();
			e.printStackTrace();
		}
		catch(NegativeAgeException e){
			e.printStackTrace();
		}
	}

	public static PersonalInfo readPersonalInfo() 
			throws NameSizeException, NegativeAgeException
	{
		String name=readName();
		int age=readAge();		
		PersonalInfo pInfo=new PersonalInfo(name, age);
		return pInfo;
	}
	
	public static String readName() throws NameSizeException
	{
		System.out.print("이름 입력: ");
		String name=sc.nextLine();
		if(name.length()<2)
			throw new NameSizeException(name);
		return name;
	}
	
	public static int readAge() throws NegativeAgeException
	{	
		System.out.print("나이 입력: ");
		int age=sc.nextInt();
		if(age<0)
			throw new NegativeAgeException();
		return age;	
	}
}


class AgeInputException extends Exception
{
	//8번 문제
	public AgeInputException()
	{
		super("유효하지 않은 나이가 입력되었습니다.");
	}

}

class ThrowsFromMain
{	
	public static void main(String[] args) throws AgeInputException
	{
		System.out.print("나이를 입력하세요: ");
		int age=readAge();
		System.out.println("당신은 "+age+"세입니다.");
	}
	
	public static int readAge() throws AgeInputException
	{
		Scanner keyboard=new Scanner(System.in);
		int age=keyboard.nextInt();
		if(age<0)
		{
			AgeInputException excpt=new AgeInputException();
			throw excpt;
		}		
		return age;
	}
}
*/

