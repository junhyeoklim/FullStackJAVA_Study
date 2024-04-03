package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

//class Box<T>
//{
//	private T ob;
//	public Box(T o) { ob = o; }
//	public T get() { return ob; }
//}

//class ToyPriceInfo {			// 장난감 모델 별 가격 정보
//    private String model;		// 모델 명
//    private int price;			// 가격
//    
//    public ToyPriceInfo(String m, int p) {
//        model = m;
//        price = p;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//    public String getModel() { return model; }
//}

public class TotalTest {

	public static void main(String[] args) {

		//		1번 문제

		//		int[] ar = {1,2,3,4,5};
		//		
		//		int sum = Arrays.stream(ar)
		//				  .filter(n -> n%2 == 1)
		//				  .sum();
		//				  
		//		System.out.println(sum);

		//		2번 문제
		//		String[] names = {"YOON", "LEE", "PARK"};
		//		
		//		 Arrays.stream(names)
		//				.forEach(n -> System.out.println(n));

		//		3번 문제

		//		double[] ds = {1.1, 2.2, 3.3, 4.4, 5.5};

		//		Arrays.stream(ds)
		//			  .forEach(d -> System.out.println(d));

		//		Arrays.stream(ds,1,4)
		//			  .forEach(d -> System.out.println(d));

		//		4번 문제

		//		List<String> list = Arrays.asList("Toy","Robot","box");
		//		
		//		list.stream()
		//			.forEach(s -> System.out.println(s));

		//		5번 문제

		//		int[] ar = {1, 2, 3, 4, 5};

		//		Arrays.stream(ar)
		//			  .filter(n -> n%2 ==1)
		//			  .forEach(n -> System.out.println(n));

		//		List<String> list = Arrays.asList("Toy","Robot","Box");
		//		
		//		list.stream()
		//			.filter(s -> s.length() == 3)
		//			.forEach(s -> System.out.println(s));

		//		6번 문제
		//		List<String> list = Arrays.asList("Box","Robot","Simple");
		//		
		//		list.stream()
		//			.map(s -> s.length())
		//			.forEach(s -> System.out.println(s));

		//		7번 문제
		//		List<Box<String>> ls = Arrays.asList(new Box<>("Robot"), new Box<>("Simple"));
		//		
		//		 ls.stream()
		//		   .map(b -> b.get())
		//		   .forEach(s -> System.out.println(s));

		//		8~9번 문제
		//		 List<Box<String>> ls = Arrays.asList(new Box<>("Robot"), new Box<>("Simple"));
		//		 
		//		 ls.stream()
		//		 .mapToInt(b -> b.get().length())
		//		 .forEach(s -> System.out.println(s));


		//		 10~11번 문제
		//	      List<ToyPriceInfo> ls = new ArrayList<>();
		//	        ls.add(new ToyPriceInfo("GUN_LR_45", 200));
		//	        ls.add(new ToyPriceInfo("TEDDY_BEAR_S_014", 350));
		//	        ls.add(new ToyPriceInfo("CAR_TRANSFORM_VER_7719", 550));

		//	   int sum = ls.stream()
		//			   		.filter(p -> p.getPrice() <500)
		//			   		.mapToInt(p -> p.getPrice())
		//			   		.sum();
		//	   
		//	   System.out.println(sum);

		//	        ls.stream()
		//	          .filter(t -> t.getModel().length() >10)
		//	          .map(m -> m.getModel())
		//	          .forEach(m -> System.out.println(m));

		//		12~13번 문제
		List<String> list = Arrays.asList("Box","Simple","Complex","Robot");

		BinaryOperator<String> ic = (s1,s2) ->
		{
			if(s1.length() > s2.length())
				return s1;
			else 
				return s2;			
		};
		//		12번 문제
		//	String str = list.stream()
		//					 .reduce("",ic);

		//		13번 문제
		String str = list.parallelStream()
				.reduce("", ic);
		System.out.println(str);

	}

}
