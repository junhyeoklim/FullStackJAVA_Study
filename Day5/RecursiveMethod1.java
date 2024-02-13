/*class RecursiveMethod1
{
	//1.팩토리얼 문제
	public static void main(String[] args)
	{
		System.out.println(factorial(3));
	}

	public static int factorial(int num)
	{
		if(num == 1) return 1;

		return num*factorial(num-1);	
	}	
}*/
/*class RecursiveMethod1
{
	//2. 1부터  n까지의 합
	public static void main(String[] args)
	{
		System.out.println(sum(100));
	}

	public static int sum(int num)
	{
		if(num == 1) return 1;

		return num+sum(num-1);	
	}	
}*/
/*class RecursiveMethod1
{
	//3. 정수 n을 전달 받아서, 2의 n승을 계산하여 반환 하는 메소드
	public static void main(String[] args)
	{
		System.out.println(mul(5));
	}

	public static int mul(int num)
	{
		if(num == 1) return 2;

		return 2*mul(num-1);	
	}	
}*/
/*class RecursiveMethod1
{
	//4. 10진수 정수를 전달받아서, 전달받은 정수에 해당하는 2진수를 출력하는 메소드(직접 푼것)
	public static void main(String[] args)
	{
		number(8);
	}

	public static void number(int num) 
	{

		if(num/2 == 0) return;
		System.out.println(num%2);    -->이렇게 하면 2로 더이상 안 나눠지는 부분 출력이 안된다.
		number(num/2);
		System.out.println(num%2);
	}	
}*/
/*class RecursiveMethod1
{
	//4. 10진수 정수를 전달받아서, 전달받은 정수에 해당하는 2진수를 출력하는 메소드
	public static void main(String[] args)
	{
		number(8);
	}

	public static void number(int num) 
	{

		if(num < 2) System.out.print(num);
		else
		{
			number(num/2);
			System.out.print(num%2);
		}
	}	
}*/
class RecursiveMethod1
{
	//5. 피보나치 수열 리턴
	public static void main(String[] args)
	{
		for(int i=1; i<10; i++)
		{	
			System.out.println(fibonacci(i)+" ");
		}
	}

	public static int fibonacci(int num) 
	{
		if(num==1 || num==2) return 1;
		
		return fibonacci(num-1)+fibonacci(num-2);		
	}	
}