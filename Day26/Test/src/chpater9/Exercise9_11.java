package chpater9;

import java.util.Scanner;

public class Exercise9_11 {

	
	public static void mol(int num1, int num2)
	{
		if(num1 < 1 || num2 > 9)
		{
			System.out.println("단의 범위는 2와 9사이의 값이어야 합니다.");
			return;
		}
		try {
			
			for(;num1 <= num2;num1++)
			{
				for(int i =1; i<=9; i++)
				{
					System.out.println(num1+"*"+i+"="+(num1*i));
				}
				System.out.println();
			}
			
		} catch (NullPointerException e) {
			System.out.println("시작 단과 끝 단, 두 개의 정수를 입력해주세요.");
		}
		
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		sc.nextLine();
		int num2 = sc.nextInt();
		sc.nextLine();
		
		mol(num1,num2);
		sc.close();
		
		

	}
}
