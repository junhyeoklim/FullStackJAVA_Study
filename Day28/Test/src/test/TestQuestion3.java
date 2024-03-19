package test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class TestQuestion3 {

	public static void main(String[] args) {

//		1번 문제
//		답 : BigInteger, BigDecimal
//		
//		2번 문제
//		
//		System.out.println("가장 큰 수 : "+Long.MAX_VALUE);
//		System.out.println("가장 작은 수 : "+Long.MIN_VALUE);
	
//		3번 문제
//		
//		BigInteger num1 = new BigInteger("100000000000000000000");
//		BigInteger num2 = new BigInteger("-99999999999999999999");
//		
//		System.out.println("덧셈 : " + num1.add(num2));
//		System.out.println("곱셈 : " + num1.multiply(num2));
		
//		4번 문제
//		
//		BigDecimal decimal1 = new BigDecimal("1.6");
//		BigDecimal decimal2 = new BigDecimal("0.1");
//		
//		System.out.println("덧셈 : "+decimal1.add(decimal2));
//		System.out.println("곱셈 : "+decimal1.multiply(decimal2));

//		5번 문제
//		답 : System.currentTimeMillis() 
		
//		6번 문제
//		답 : 컴퓨터가 가짜 시드를 생성 한다
//		
//		8번 문제
//		답 : public String nextToken();
		
//		9번 문제
//		답 : public booelean hasMoreTokens();

		
//		10,11번 문제
//		String src = "11:22:33:44:55";
		
//		StringTokenizer str = new StringTokenizer(src,":");		
//		
//		while(str.hasMoreTokens())
//			System.out.println(str.nextToken());
		
//		String src2 = "Tel 82-02-997-2059";
		String src2 = "num+=1";
//		StringTokenizer str2 = new StringTokenizer(src2," ");
//		StringTokenizer str2 = new StringTokenizer(src2," -");
		StringTokenizer str2 = new StringTokenizer(src2,"+=",true);
		
		while(str2.hasMoreTokens())
			System.out.println(str2.nextToken());
	}

}
