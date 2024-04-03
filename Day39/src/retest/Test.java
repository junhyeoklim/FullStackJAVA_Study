package retest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//interface Printable {
//    void print(String s);    // 매개변수 하나, 반환형 void
//}
//interface Calculate {
//    void cal(int a, int b);    // 매개변수 둘, 반환형 void
//}
//interface Calculate {
//    int cal(int a, int b);
//}
//interface HowLong {
//    int len(String s);    // 값을 반환하는 메소드
//}
//interface RandomNum
//{
//	int random();
//}
//interface Calculate<T>
//{
//	T cal(T num1,T num2);
//}
//interface Calculate<T>{
//	T cal(T a, T b);
//}
class Box<T>{
	private T ob;
	public void set(T o) { ob = o; }
	public T get() { return ob;}
}
class Test {
//	public static <T> void calAndShow(Calculate<T> op, T n1, T n2) {
//		T r = op.cal(n1,  n2);
//		System.out.println(r);
//	}
//    public static int sum(Predicate<Integer> p, List<Integer> lst) {
//        int result = 0;
//        
//        for(int n : lst)
//        	if(p.test(n))
//        		result += n;
//        return result;
//     }
//	public static <T> void show(Predicate<T> p, List<T> lst) {
//		
//		for(T n: lst)
//			if(p.test(n))
//				System.out.print(n+" ");
//		System.out.println();
//		
//	}
//	public static <T> void show(IntPredicate ip, List<Integer> lst) {
//		
//		for(int n: lst)
//			if(ip.test(n))
//				System.out.print(n+" ");
//		System.out.println();
//		
//	}
//    public static List<Integer> makeIntList(Supplier<Integer> s, int n) {
//        List<Integer> list = new ArrayList<>();    
//        for(int i = 0; i < n; i++)
//            list.add(s.get());
//        return list;
//    }
//    public static List<Integer> makeIntList(IntSupplier s, int n) {
//    	List<Integer> list = new ArrayList<>();    
//    	for(int i = 0; i < n; i++)
//    		list.add(s.getAsInt());
//    	return list;
//    }

    public static void main(String[] args) {
    	
//    	1번 문제
//        List<String> list = new ArrayList<>();
//        list.add("Robot");
//        list.add("Lambda");
//        list.add("Box");
//
//        Collections.sort(list, (s1,s2) -> s1.length() - s2.length());    // 정렬
//
//        for(String s : list)
//            System.out.println(s);
    	
//    	2번 문제 
//    	 Printable p = s -> System.out.println(s);;
//         p.print("Lambda exp one.");
    	
//    	3번 문제
//    	 Calculate c;
//         c =  (n1,n2) -> System.out.println(n1+n2);
//         c.cal(4, 3);
//
//         c = (n1,n2) -> System.out.println(n1-n2);
//         c.cal(4, 3);
//
//         c = (n1,n2) -> System.out.println(n1*n2);
//         c.cal(4, 3);
    	
//    	4번 문제
//    	 Calculate c;
//         
//         c = (n1,n2) -> n1+n2;
//         System.out.println(c.cal(4, 3));
    	
//    	5번 문제
//    	HowLong hl = s -> s.length();
//        System.out.println(hl.len("I am so happy"));
    	
//    	6번 문제
//    	답 : 추상 메소드가 1개만 가지고 있고 람다로 표현 할 수 있는 인터페이스다.
//    	
//    	RandomNum rand;
//    	
//    	rand = ()->	(int)(Math.random()*50);
//    	
//    	System.out.println(rand.random());
    	
//    	7번 문제
//    	
//    	 Calculate<Integer> ci = (a, b) -> a + b;
//         System.out.println(ci.cal(4, 3));
//
//         Calculate<Double> cd = (a, b) -> a + b;
//         System.out.println(cd.cal(4.32, 3.45));
    	
//    	7-1번 문제	
//    	
//    	calAndShow((a, b) -> a + b, 3, 4);
//    	calAndShow((a, b) -> a + b, 2.5,7.1);
//    	calAndShow((a, b) -> a - b, 4, 2);
//    	calAndShow((a, b) -> a - b, 4.9, 3.2);
//    	
//    	// 3 + 4
//    			// 2.5 + 7.1
//    			// 4 - 2
//    			// 4.9 - 3.2
    	
//    	7-2번 문제
//    	List<String> list = new ArrayList<>();
//        list.add("Robot");
//        list.add("Lambda");
//        list.add("Box");
//
//        Collections.sort(list, (s1,s2) -> s1.length()-s2.length());    // 정렬
//
//        for(String s : list)
//            System.out.println(s);
    	
//    	8-1번 문제
//    	 List<Integer> list = Arrays.asList(1, 5, 7, 9, 11, 12);
//    	    
//         int s;
//         s = sum(n->n%2 == 0, list);
//         System.out.println("짝수 합: " + s);
//
//         s = sum(n->n%2 != 0, list);
//         System.out.println("홀수 합: " + s);
    	
//    	8-2번 문제
//    	List<Integer> lst1 = Arrays.asList(1, 3, 8, 10, 11);
//		show(n->n%2!= 0, lst1);	// 홀수만 출력
//		
//		List<Double> lst2 = Arrays.asList(-1.2, 3.5, -2.4, 9.5);
//		show(n->n>0.0, lst2);
    	
//    	9번 문제
//    	List<Integer> lst1 = Arrays.asList(1, 3, 8, 10, 11);
//		show(n->n%2!= 0, lst1);	// 홀수만 출력
//		
//		List<Double> lst2 = Arrays.asList(-1.2, 3.5, -2.4, 9.5);
//		show(n->n>0.0, lst2);
    	
//    	9-1번 문제
//    	BiPredicate<String, Integer> conv = (s,n) -> 
//    	{
//    		if(s.length() > 3)
//    			return true;
//    		else
//    			return false;
//		};
//    			
//    			// test 호출 결과 문자열 "Robot"의 길이가 3을 넘으면 true 반환
//    			if(conv.test("Robot", 3))
//    				System.out.println("문자열 길이 3 초과");
//    			else
//    				System.out.println("문자열 길이 3 이하");
//    			
//    			// test 호출 결과 문자열 "Box"의 길이가 5를 넘으면 true 반환
//    			if(conv.test("Box", 5))
//    				System.out.println("문자열 길이 5 초과");
//    			else
//    				System.out.println("문자열 길이 5 이하");
    	
//    	10번 문제
//    	Supplier<Integer> spr = () ->
//    	{
//    		Random rand = new Random();
//			return rand.nextInt(50);    		
//    	};
//
//    	        List<Integer> list = makeIntList(spr, 5);
//    	        System.out.println(list);
//
//    	        list = makeIntList(spr, 10);
//    	        System.out.println(list);
    	
//    	11번 문제
//    	IntSupplier spr = () ->
//    	{
//    		Random rand = new Random();
//			return rand.nextInt(50);    		
//    	};
//
//    	        List<Integer> list = makeIntList(spr, 5);
//    	        System.out.println(list);
//
//    	        list = makeIntList(spr, 10);
//    	        System.out.println(list);
    	
//    	12번 문제
//    	 Consumer<String> c = s -> System.out.println(s);;
//         
//         c.accept("Pineapple");    // 출력이라는 결과를 보임
//         c.accept("Strawberry");
    	
//    	13-1번 문제
//    	 ObjIntConsumer<String> c = (s,i) -> System.out.println(i+". "+s);
//
//    		        int n = 1;
//    		        c.accept("Toy", n++);
//    		        c.accept("Book", n++);
//    		        c.accept("Candy", n);
    	
//    	13-2번 문제
//    	BiConsumer<Box<Integer>,Integer> bIcos = (b,i) ->
//    	{
//    		b.set(i);
//    		System.out.println(b.get());
//    	};
//    	BiConsumer<Box<Double>,Double> bDcos = (b,i) ->
//    	{
//    		b.set(i);
//    		System.out.println(b.get());
//    	};
//    	
//    	Box<Integer> b1 = new Box<>();
//    	Box<Double> b2 = new Box<>();
//    	
//    	bIcos.accept(b1, 12);
//    	bDcos.accept(b2, 1.2);
    	
//    	14번 문제
//    	Function<String, Integer> f = s -> s.length();
//
//        System.out.println(f.apply("Robot"));
//        System.out.println(f.apply("System"));
    	
//    	15번 문제
//    	Function<Double, Double> cti = i -> i*0.393701;
//        Function<Double, Double> itc = i -> i*2.54;
//
//        System.out.println("1cm = " + cti.apply(1.0) + "inch");		// cm를 inch로
//        System.out.println("1inch = " + itc.apply(1.0) + "cm");		// inch를 cm로

//    	16번 문제
//    	ToIntFunction<String> f = s -> s.length();
//
//        System.out.println(f.applyAsInt("Robot"));
//        System.out.println(f.applyAsInt("System"));
    	
//    	17번 문제
//    	DoubleUnaryOperator cti = i -> i*0.393701;
//    	DoubleUnaryOperator itc = i -> i*2.54;
//
//    	System.out.println("1cm = " + cti.applyAsDouble(1.0) + "inch");
//    	System.out.println("1inch = " + itc.applyAsDouble(1.0) + "cm");
    	
//    	18번 문제
//    	List<Integer> ls1 = Arrays.asList(1, -2, 3, -4, 5);
//        ls1 = new ArrayList<>(ls1);
//
//        List<Double> ls2 = Arrays.asList(-1.1, 2.2, 3.3, -4.4, 5.5);
//        ls2 = new ArrayList<>(ls2);
//        
//        Predicate<Number> p = n -> n.doubleValue()<0.0;
//        
//        ls1.removeIf(p);
//        ls2.removeIf(p);
//
//        System.out.println(ls1);
//        System.out.println(ls2);
       
    }
}