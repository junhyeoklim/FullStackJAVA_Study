package retest;

import java.util.function.ToIntBiFunction;

//class JustSort {
//    public void sort(List<?> lst) {    // 인스턴스 메소드
//    	 Collections.reverse(lst);
//    }
//}
class IBox {
    private int n; 

    public IBox(int i) { n = i; }

    public int larger(IBox b) {
        if(n > b.n)
            return n;
        else
            return b.n;
    }
}


public class Test2 {

	public static void main(String[] args) {

		//		ArrayList<Integer> array = new ArrayList<>();
		//		
		//		for(int i=0; i<10;i++)
		//			if(i%2 != 0)
		//				array.add(i);
		////		1번 문제
		////		Consumer<ArrayList<Integer>> cos = s -> Collections.reverse(array);
		//		   2번문제
		//		Consumer<ArrayList<Integer>> cos = Collections::reverse;
		//		
		//		cos.accept(array);
		//		
		//		
		//		
		//		System.out.println(array);

		//		 List<Integer> ls = Arrays.asList(1, 3, 5, 7, 9);
		//	        ls = new ArrayList<>(ls);
		//	        JustSort js = new JustSort();

		//	        3번 문제
		//	        Consumer<List<Integer>> cons = s -> js.sort(s);;
		//	        4번 문제
		//	        Consumer<List<Integer>> cons = js::sort;
		//	        
		//	        cons.accept(ls);
		//	        
		//	        System.out.println(ls);

//		List<Integer> box = Arrays.asList(1,2,3,4,5,6);
//		List<Integer> Robot = Arrays.asList(3,4,1,4,3,2);
//		
//		Consumer<List<Integer>> cos = s -> Collections.reverse(s);
//		
//		cos.accept(box);
//		cos.accept(Robot);
//		
//		System.out.println("box : "+box);
//		System.out.println("Robot : "+Robot);
		
		 IBox ib1 = new IBox(5);
	        IBox ib2 = new IBox(7);

	        // 두 상자에 저장된 값 비교하여 더 큰 값 반환
	        ToIntBiFunction<IBox, IBox> bf = (b1,b2) -> b1.larger(b2); 
	        int bigNum = bf.applyAsInt(ib1, ib2);
	        System.out.println(bigNum);

	}
}

