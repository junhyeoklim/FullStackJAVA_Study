package study;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Wrapper;
import java.util.StringTokenizer;

public class DefaultClassTest {

	public static void main(String[] args) {
		// 1번문제
		// 답 : BigInteger,BigDecimal

		//	2번 문제 
		//	System.out.println("최대 정수 : "+Long.MAX_VALUE);
		//	System.out.println("최소 정수 : "+Long.MIN_VALUE);

		//	3번 문제		
		//	BigInteger num1 = new BigInteger("100000000000000000000");
		//	BigInteger num2 = new BigInteger("-99999999999999999999");
		//		
		//	System.out.println("더하기 : "+num1.add(num2));
		//	System.out.println("곱하기 : "+num1.multiply(num2));

		//	4번 문제 
		//	BigDecimal num1 = new BigDecimal(1.6);
		//	BigDecimal num2 = new BigDecimal(0.1);
		//	
		//	System.out.println("더하기 : "+num1.add(num2));
		//	System.out.println("곱하기 : "+num1.multiply(num2));
		//	//오차 없는 계산
		//	BigDecimal num1 = new BigDecimal("1.6");
		//	BigDecimal num2 = new BigDecimal("0.1");
		//	System.out.println("더하기 : "+num1.add(num2));
		//	System.out.println("곱하기 : "+num1.multiply(num2));
		
		//	5번 문제
		//	답 : System.currentTimeMillis()
		//
		//	6번 문제
		//	답 : 지정된 시드값을 기준으로 난수를 발생한다.
		//	8번 문제
		//	답 : hasMoreTokens()

		//	9번 문제
		//	답 : nextTokens()

		//	10번 문제		
		//	String data = "11:22:33:44:55";
		//	
		//	StringTokenizer token = new StringTokenizer(data,":");
		//	
		//	while(token.hasMoreTokens())
		//		System.out.println(token.nextToken());

		//	11번 문제
		//	String data = "TEL 82-02-997-2059";

		//	11-1
		//	StringTokenizer token = new StringTokenizer(data," ");
		//	
		//	while(token.hasMoreTokens())
		//		System.out.println(token.nextToken());
		//	System.out.println();

		//	//11-2
		//	StringTokenizer token = new StringTokenizer(data," -");
		//	while(token.hasMoreTokens())
		//		System.out.println(token.nextToken());

		//11-3
		//	String data = "num+=1";
		//	StringTokenizer token = new StringTokenizer(data,"+=",true);
		//	while(token.hasMoreTokens())
		//		System.out.println(token.nextToken());
	}

}
