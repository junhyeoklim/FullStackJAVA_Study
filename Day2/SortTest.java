import java.util.Scanner;

class SortTest
{
	public static void main(String[] args)
	{
		int[] num = new int[5];
		int temp =0,i=0,k=0;

		Scanner sc = new Scanner(System.in);

		for(i =0;i<5;i++)
		{
		System.out.println((i+1)+"번째 숫자를 입력 하시오");
		num[i] = sc.nextInt();
		}		
		sc.close();

		for(i=0;i<5;i++)
		{
			for(k=0;k<=4;k++)
			{			
			  if(num[i] > num[i+1])
			   {
				temp = num[i+1];
				num[i+1] = num[i];
				num[i] = temp;
		  	    }
			  }
		}
		for(i = 0;i<5;i++)
		  System.out.print(num[i]);		
		
	}
}
/*class SortTest
{
	public static void main(String[] args)
	{
		int num1 = 0, num2 = 0,num3=0,num4=0,num5=0;
		int temp =0;

		Scanner sc = new Scanner(System.in);

		System.out.println("첫 번째 숫자를 입력 하시오");
		num1 = sc.nextInt();
		System.out.println("두 번째 숫자를 입력 하시오");
		num2 = sc.nextInt();
		System.out.println("세 번째 숫자를 입력 하시오");
		num3 = sc.nextInt();
		System.out.println("네 번째 숫자를 입력 하시오");
		num4 = sc.nextInt();
		System.out.println("다섯 번째 숫자를 입력 하시오");
		num5 = sc.nextInt();
		sc.close();

		if(num1 > num2)
		{  
			temp = num2;
			num2 = num1;
			num1 = temp;
		}
		if(num1 > num3)
		{
			temp = num3;
			num3 = num1;
			num1 = temp;
		}
		if(num1 > num4)
		{
			temp = num4;
			num4 = num1;
			num1 = temp;
		}
		if(num1 > num5)
		{
			temp = num5;
			num5 = num1;
			num1 = temp;
		}

		if(num2 > num3)
		{  
			temp = num3;
			num3 = num2;
			num2 = temp;
		}
		if(num2 > num4)
		{
			temp = num4;
			num4 = num2;
			num2 = temp;		
		}
		if(num2 > num5)
		{
			temp = num5;
			num5 = num2;
			num2 = temp;
		}

		if(num3 > num4)
		{
			temp = num4;
			num4 = num3;
			num3 = temp;
		}
		if(num3 > num5)
		{
			temp = num5;
			num5 = num3;
			num3 = temp;
		}
		if(num4 > num5)
		{
			temp = num5;
			num5 = num4;
			num4 = temp;
		}

		System.out.println("오름차순으로 정리"+num1+num2+num3+num4+num5);		
		
	}
}
*/