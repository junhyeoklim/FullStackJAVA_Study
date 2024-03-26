package test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;

public class CollectionFrameWork {

	public static void main(String[] args) {

//		1번 문제
//		HashSet createNum = new HashSet<>();
//		
//		while(createNum.size() < 6)
//		{
//			int random = (int) (Math.random()*45+1);
//			createNum.add(random);
//		}
//		
//		LinkedList sortNum = new LinkedList<>(createNum);		
//		Collections.sort(sortNum);
//		
//		System.out.println(sortNum);
		
//		2번 문제
		
		LinkedHashSet bingo = new LinkedHashSet<>();
//		HashSet bingo = new HashSet<>();
		
		while(bingo.size()<25)
		{
			bingo.add((int)(Math.random()*50+1));
		}
		
		Iterator<Integer> itr = bingo.iterator();
		int i=0;
		while(itr.hasNext()) {
			System.out.print(itr.next()+"\t");
			i++;
			if(i%5==0) {
				System.out.println();
				i=0;
			}
		}
	}

}
