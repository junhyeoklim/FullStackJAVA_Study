//package test;
//
//import java.util.function.BiConsumer;
//
////public class TestQuestion {
////
////	public static <T> void show(Predicate<T> p, List<T> lst) {
////				
////		for(T n : lst)
////			if(p.test(n))
////				System.out.println(n);
////				
////		
////		
////	}
////	public static void main(String[] args) {
////		List<Integer> lst1 = Arrays.asList(1, 3, 8, 10, 11);
////		show(n->n%2!= 0, lst1);	// 홀수만 출력
////		
////		List<Double> lst2 = Arrays.asList(-1.2, 3.5, -2.4, 9.5);
////		show(n->n>0.0, lst2);		// 0.0 보다 큰 수 출력
////	}
////}
//
//class Box<T>
//{
//	private T ob;
//	public void set(T o) 
//	{
//		ob =o;
//	}
//	public T get() 
//	{
//		return ob;
//	}
//}
//
//
//
//public class TestQuestion {
//	public static void main(String[] args) {
//		//		BiPredicate<String, Integer> conv = (s,n) -> {
//		//			if(s.length() > 3)
//		//				return true;
//		//			else
//		//			return false;};
//		//		if(conv.test("Robot", 3))
//		//			System.out.println("문자열 길이 3 초과");
//		//		else
//		//			System.out.println("문자열 길이 3 이하");
//		//		
//		//		// test 호출 결과 문자열 "Box"의 길이가 5를 넘으면 true 반환
//		//		if(conv.test("Box", 5))
//		//			System.out.println("문자열 길이 5 초과");
//		//		else
//		//			System.out.println("문자열 길이 5 이하");
//		
//		BiConsumer<Box<Integer>,Integer> incos = (b,n) -> 
//		{
//			b.set(n);
//			System.out.println(b.get());			
//		};
//		BiConsumer<Box<Double>,Double> docos = (b,n) ->
//		{
//			b.set(n);
//			System.out.println(b.get());
//		};
//		
//		Box<Integer> b1 = new Box<>();
//		Box<Double> b2 = new Box<>();
//		
//		
//		incos.accept(b1, 12);		 
//		docos.accept(b2, 3.14);
//		
////		System.out.println(b1.get());
////		System.out.println(b2.get());
//		
//	}
//}