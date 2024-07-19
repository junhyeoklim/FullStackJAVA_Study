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
		//		답 : a 이유는 첫 번째 요소를 삭제 후 뒤에 있는 요소들을 앞으로 댕겨야 하므로 비용+시간이 많이 든다.

		//		11-4번 문제
		//		답 : 6번째 요소 이유: 원형 연결 리스트라 앞으로 접근 하나 뒤로 접근하나 가운데에 접근 하는 횟수가 가장 높다.
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
