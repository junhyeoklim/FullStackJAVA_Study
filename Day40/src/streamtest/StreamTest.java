package streamtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//class ReportCard {
//	private int kor;    // 국어 점수
//	private int eng;    // 영어 점수
//	private int math;    // 수학 점수
//
//	public ReportCard(int k, int e, int m) {
//		kor = k;
//		eng = e;
//		math = m;    
//	}
//	public int getKor() { return kor; }
//	public int getEng() { return eng; }
//	public int getMath() { return math; }
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
		//		int[] num = {11,22,33,44};
		//		String[] str1 = {"So Simple"};
		//		String[] str2 = {"Toy","Robot","Box"};
		//		
		//		Arrays.stream(num)
		//			  .forEach(s -> System.out.println(s));
		//
		//		Arrays.stream(str1)
		//				.forEach(s -> System.out.println(s));
		//		Arrays.stream(str2)
		//			.forEach(s -> System.out.println(s));

		//		2번 문제

		//		IntStream num1 = IntStream.of(7,5,3);
		//		
		//		num1.forEach(s -> System.out.print(s));
		//		System.out.println();
		//		
		//		IntStream num2 = IntStream.range(5,8);
		//		num2.forEach(s -> System.out.print(s));
		//		System.out.println();
		//		
		//		IntStream num3 = IntStream.rangeClosed(5,8);
		//		num3.forEach(s -> System.out.print(s));

		//		3번 문제
		//		List<String> list = Arrays.asList("Box","Simple","Complex","Robot");
		//		
		//		BinaryOperator<String> ic = (s1,s2) ->
		//			{
		//				if(s1.length() > s2.length())
		//					return s1;
		//				else
		//					return s2;
		//			};
		//			
		//			String str = list.stream()
		//							 .reduce("", ic);
		//			
		//			System.out.println(str);
		//		
		//			String str = list.parallelStream()
		//					.reduce("", ic);
		//			
		//			System.out.println(str);

		//		4번 문제
		//		Stream<String> st1 = Arrays.asList("Cake","Milk").stream();
		//		Stream<String> st2 = Arrays.asList("Lemon","Jelly").stream();
		//		
		//		Stream.concat(st1, st2).forEach(s -> System.out.print(s+"\t"));

		//		5번 문제
		//		
		//		Stream<String> st1 = Stream.of("Operation_Sort");
		//		
		//		Stream<String> st2 = st1.flatMap(s -> Arrays.stream(s.split("_")));
		//		
		//		st2.forEach(s -> System.out.print(s+"\t"));

		//		6번 문제
		//        ReportCard[] cards = {
		//                new ReportCard(70, 80, 90),
		//                new ReportCard(90, 80, 70),
		//                new ReportCard(80, 80, 80)
		//            };  
		//		
		//        Stream<ReportCard> st = Stream.of(cards);
		//        
		//       IntStream avg = st.flatMapToInt(s -> IntStream.of(s.getEng(),s.getKor(),s.getMath()));
		//       
		//       double result = avg.average().getAsDouble();
		//       System.out.println(result);

		//		7번 문제

		//		Stream<String> st = Stream.of("Box","Apple","Robot");
		//
		//		st.sorted()
		//		  .forEach(s -> System.out.println(s));
		//		
		//		
		//		st.sorted((s1, s2) -> s1.length() - s2.length())
		//		  .forEach(s -> System.out.println(s));

		//		8번 문제

		//		Stream<Integer> st = Stream.of(3,9,4,2);
		//		
		//		st.sorted()
		//		  .forEach(n -> System.out.println(n));
		//		
		//		Stream<Double> st = Stream.of(3.3,6.2,1.5,8.3);
		//		
		//		st.sorted()
		//		.forEach(n -> System.out.println(n));

		//		9번 문제
		// 최종 연산이 생략된 스트림의 파이프라인
		//        IntStream.of(1, 3, 5)
		//            .peek(d -> System.out.print(d + "\t"));
		//        System.out.println();
		//
		//  
		//        // 최종 연산이 존재하는 스트림의 파이프라인
		//        IntStream.of(5, 3, 1)
		//            .peek(d -> System.out.print(d + "\t"))
		//            .sum();            
		//        System.out.println();

		//		답 : 1	3	5 
		//          5	3	1 이 출력될 것이다 이유는 peek이 파이프 흐름을 보는거라서?
		//        실행 결과 : 5	3	1 이유 : api설명 보면 peek이 디버깅 확인을 위해 쓰는 용도라고 했으니
		//         최종 연산이 없어서 첫번째는 중간 연산이 실행 되지 않았다.

		//        10번 문제

		//        int sum = IntStream.of(1,3,5,7,9)
		//        		  .sum();
		//        System.out.println("합 : "+ sum);
		//        
		//        long cnt = IntStream.of(1,3,5,7,9)
		//        		.count();
		//        System.out.println("개수 : "+ cnt);
		//        
		//        double avg = IntStream.of(1,3,5,7,9)
		//        		.average()
		//        		.getAsDouble();
		//        System.out.println("평균 : "+ avg);
		//        
		//   		IntStream.of(1,3,5,7,9)
		//        		.min()
		//        		.ifPresent(s -> System.out.println("최소 : "+ s));
		//        
		//         IntStream.of(1,3,5,7,9)
		//        		.max()
		//        		.ifPresent(s -> System.out.println("최대 : "+s));

		//        11번 문제

//		boolean b = IntStream.of(1, 2, 3, 4, 5)
//				.allMatch(n -> n%2 == 0);
//		System.out.println("모두 짝수이다. " + b);
//
//		b = IntStream.of(1, 2, 3, 4, 5)
//				.anyMatch(n -> n%2 == 0);
//		System.out.println("짝수가 하나는 있다. " + b);
//
//		b = IntStream.of(1, 2, 3, 4, 5)
//				.noneMatch(n -> n%2 == 0);
//		System.out.println("짝수가 하나도 없다. " + b);


//		답 : 모두 짝수이다. false
//			 짝수가 하나는 있다. true
//			 짝수가 하나도 없다. false
		
//		12번 문제
//		 ReportCard[] cards = {
//		            new ReportCard(98, 84, 90),
//		            new ReportCard(92, 87, 95),
//		            new ReportCard(85, 99, 93)
//		        };    
//		 
//		 
//		 boolean b1 = Stream.of(cards).mapToDouble(n -> (n.getEng()+n.getKor()+n.getMath()) / 3.0)
//				 		.anyMatch(avg -> avg >=90.0);
//		 
//		 System.out.println("평균 90 이상이 한 명 이상 존재합니다."+b1);
//		 
//		 if(b1 == true)
//		 {
//			 boolean b2 = Stream.of(cards).mapToDouble(n -> (n.getEng()+n.getKor()+n.getMath()) / 3.0)
//					 	.peek(d -> System.out.println(d))
//				 		.allMatch(avg -> avg >=90.0);
//			 System.out.println("모두 평균 90 이상입니다."+b2);
//		 }
		 
		 
//		13번 문제
		String[] list = {"Hello","Box","Robot","Toy"};
		
		Stream<String> st = Arrays.stream(list);
		
//		List<String> ls = st.filter(s -> s.length() <5)
//							.collect(
//									() -> new ArrayList<>(),
//									(c,s) -> c.add(s),
//									(lst1,lst2) -> lst1.addAll(lst2));
									
		List<String> ls = st.parallel()
				.filter(s -> s.length() <5)
				.collect(
						() -> new ArrayList<>(),
						(c,s) -> c.add(s),
						(lst1,lst2) -> lst1.addAll(lst2));
		System.out.println(ls);
			  
				 	 
				 	   

	}

}
