package chapter11EX;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

public class Exercise11_2 {

	public static void main(String[] args) {
		//		ArrayList<Integer> list = new ArrayList<>();
		//		list.add(3);
		//		list.add(6);
		//		list.add(2);
		//		list.add(2);
		//		list.add(2);
		//		list.add(7);
		//		HashSet<Integer> set = new HashSet<>(list);
		//		TreeSet<Integer> tset = new TreeSet<>(set);
		//		Stack<Integer> stack = new Stack<>();
		//		stack.addAll(tset);
		//		while(!stack.empty())
		//		System.out.println(stack.pop());

		//		실행 결과 : 우선 HashSet으로 중복을 없앴으므로 2,3,6,7이 무작위로 저장되고
		//				 TreeSet으로 순차 저장을 했으므로 2,3,6,7이 저장 되어있다
		//			 	이 상태에서 스택에 저장 한 후 꺼냈으므로 7,6,3,2이 나온다

		//		11-3번 문제
		//		답 : d 이유는 중간에 새로운 요소가 추가 되면 추가된 이후에 모든 요소를 1칸씩 뒤로 밀어내야 하므로 시간+비용이 많이 든다.

		//		11-4번 문제
		//		답 : 11번째 요소?
//		LinkedList list = new LinkedList<>(); 
//
//		long start = System.currentTimeMillis();
//		for(int i=0; i<11;i++)
//		{
//			
//			list.add(i+"");		
//			long end = System.currentTimeMillis();
//			System.out.println((i+1)+"번째 저장 시간 : "+(end-start));
//		}
		
		 
		
	}

}
