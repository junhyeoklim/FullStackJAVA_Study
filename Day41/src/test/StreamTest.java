package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//class ReportCard {
//    private int kor;    // 국어 점수
//    private int eng;    // 영어 점수
//    private int math;    // 수학 점수
//    
//    public ReportCard(int k, int e, int m) {
//        kor = k;
//        eng = e;
//        math = m;    
//    }
//    public int getKor() { return kor; }
//    public int getEng() { return eng; }
//    public int getMath() { return math; }
//}

class ReportCard {
    private int kor;    // 국어 점수
    private int eng;    // 영어 점수
    private int math;    // 수학 점수
    
    public ReportCard(int k, int e, int m) {
        kor = k;
        eng = e;
        math = m;    
    }
    public int getKor() { return kor; }
    public int getEng() { return eng; }
    public int getMath() { return math; }
}


public class StreamTest {

	public static void main(String[] args) {

//		1번 문제
//				Stream.of(11,22,33,44)
//					  .forEach(s -> System.out.println(s));
//				
//				Stream.of("So Simple")
//				.forEach(s -> System.out.println(s));
//				
//				Stream.of("Toy","Robot","Box")
//				.forEach(s -> System.out.println(s));
		
//		2번 문제
//		IntStream.of(7,5,3)
//				.forEach(s -> System.out.print(s+"\t"));
//		System.out.println();
//		
//		IntStream.range(5, 8)
//				 .forEach(s -> System.out.print(s+"\t"));
//		System.out.println();
//		
//		IntStream.rangeClosed(5, 8)
//		.forEach(s -> System.out.print(s+"\t"));
		
//		3번 문제
		
//		BinaryOperator<String> bo = (s1,s2) ->
//		{
//			if(s1.length() > s2.length())
//				return s1;
//			else
//				return s2;
//		};
//		
//	String str = Stream.of("Box","Simple","Complex","Robot")
//			  			.reduce("",bo);
//	
//	System.out.println(str);
			  
//		4번 문제
//		Stream<String> st1 = Stream.of("Cake","Milk");
//		Stream<String> st2 = Stream.of("Lemon","Jelly");
//		
//		Stream.concat(st1, st2).forEach(s -> System.out.println(s));
		
//		5번 문제
		
//		Stream.of("Operation_Complete")
//			  .flatMap(s -> Arrays.stream(s.split("_")))
//			  .forEach(s -> System.out.println(s));
		
//		6번 문제
		
//		ReportCard[] cards = {
//	            new ReportCard(70, 80, 90),
//	            new ReportCard(90, 80, 70),
//	            new ReportCard(80, 80, 80)
//	        };    
//		
//		IntStream is = Arrays.stream(cards)
//							.flatMapToInt(n -> IntStream.of(n.getEng(),n.getKor(),n.getMath()));
//		
//		double avg = is.average()
//						.getAsDouble();
//		
//		System.out.println(avg);
		
//		7번 문제
		
//		Stream.of("Box","Apple","Robot")
//			  .sorted()
//			  .forEach(s -> System.out.println(s));
//		
//		Stream.of("Box","Apple","Robot")
//		.sorted((s1,s2) -> s1.length() - s2.length())
//		.forEach(s -> System.out.println(s));
		
//		8번 문제
//		IntStream.of(3,9,4,2)
//				  .forEach(n -> System.out.println(n));
//		
//		DoubleStream.of(3.3,6.2,1.5,8.3)
//					.forEach(d -> System.out.println(d));
		
//		9번 문제
//		답 : 전자는 최종연산이 생략되어 중간 연산이 아예 실행이 안되어 아무것도 출력이 안되지만
//		     후자는 최종 연산이 존재 하므로 스트림 이름 그대로 중간 연산 후 최종 연산까지 동작 하게 된다
		
//		10번 문제
		
//		int sum =	IntStream.of(1,3,5,7,9)
//							.sum();
//		System.out.println("sum : "+sum);
//		
//		long cnt =	IntStream.of(1,3,5,7,9)
//				.count();
//		System.out.println("sum : "+cnt);
//		
//		double avg =	IntStream.of(1,3,5,7,9)
//						.average()
//						.getAsDouble();
//		System.out.println("sum : "+avg);
//		
//		int min = IntStream.of(1,3,5,7,9)
//							.min().getAsInt();
//		System.out.println("sum : "+min);
//		
//		int max =	IntStream.of(1,3,5,7,9)
//								.max().getAsInt();
//		System.out.println("sum : "+max);
		
//		11번 문제
//		답 : 모두 짝수이다 false
//			짝수가 하나는 있다. true
//			짝수가 하나도 ㅇ벗다. false
		
//		12번 문제
		
//		 ReportCard[] cards = {
//		            new ReportCard(98, 84, 90),
//		            new ReportCard(92, 87, 95),
//		            new ReportCard(85, 99, 93)
//		        };      
//		 
//		 	boolean b1 = Stream.of(cards)
//		 					 .mapToDouble(s -> (s.getEng()+s.getKor()+s.getMath())/3.0)
//		 					 .anyMatch(s -> s >=90);
//		 	
//		 	System.out.println("평균 90 이상이 한 명 이상 존재합니다. "+b1);
//		 			
//		 	boolean b2 = Stream.of(cards)
//		 			.mapToDouble(s -> (s.getEng()+s.getKor()+s.getMath())/3.0)
//		 			.allMatch(s -> s >=90);
//		 	
//		 	System.out.println("모두 평균 90 이상입니다. "+b2);
		
//		13번 문제
//		String[] srr = {"Hello","Box","Robot","Toy"};
		
//		List<String> list = Arrays.stream(srr)
//								  .filter(s -> s.length() <5)
//								  .collect(() ->
//								  new ArrayList<>(),
//									(c,s) -> c.add(s),
//									(lst1,lst2) -> lst1.addAll(lst2));
//		
//		list.forEach(s -> System.out.println(s));
		
//		14번 문제
		
//		List<String> list = Arrays.stream(srr)
//									.parallel()
//									.filter(s -> s.length() <5)									
//									.collect(() ->
//				new ArrayList<>(),
//				(c,s) -> c.add(s),
//				(lst1,lst2) -> lst1.addAll(lst2));
//		
//		list.forEach(s -> System.out.println(s));
//		
	}

}
