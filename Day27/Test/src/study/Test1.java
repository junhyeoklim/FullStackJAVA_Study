package study;

import java.math.BigDecimal;
import java.util.Scanner;

public class Test1 {

	public static BigDecimal abs(String num1, String num2)
	{
		BigDecimal big1 = new BigDecimal(num1);
		BigDecimal big2 = new BigDecimal(num2);
		BigDecimal sub = big1.subtract(big2);
		
		
		return sub.abs();
	}
	
	
	public static void main(String[] args) {
		//BigDecimal을 사용할때 오차 없이 사용하기 위해서 쓰는 방법
		Scanner sc = new Scanner(System.in);
		System.out.print("실수 입력1 : ");
		String num1 = sc.nextLine();
		
		System.out.print("실수 입력2 : ");
		String num2 = sc.nextLine();
		
		System.out.println(abs(num1,num2));
	}

}
