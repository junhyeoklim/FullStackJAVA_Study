package test;

import java.math.BigDecimal;
import java.util.Scanner;

public class TestQuestion2 {

	public static double numSubAbs(double num1,double num2)
	{
		BigDecimal decimal1 = new BigDecimal(num1);
		BigDecimal decimal2 = new BigDecimal(num2);
		
		return decimal1.subtract(decimal2).abs().doubleValue();
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 실수 입력 : ");
		double num1 = sc.nextDouble();
		sc.nextLine();
		
		System.out.print("두 번째 실수 입력 : ");
		double num2 = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("결과 : "+ numSubAbs(num1, num2));
		
	}

}
