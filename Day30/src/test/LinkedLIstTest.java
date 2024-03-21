package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.HashSet;

public class LinkedLIstTest {

	public static void main(String[] args) {

//		LinkedList<String> array = new LinkedList<>();
//		array.add("First");
//		array.add("Second");
//		array.add("Thrid");
//		array.add("Fourth");
		
		
//		array.add(0, 11);;
//		array.add(1, 22);
//		array.add(2, 33);
//		
//		Iterator<String> arrayiter2 = array.iterator();		
//		int i =0;
//		for(String curs : array)
//		{
//			System.out.println(curs);
//			
//			if(curs.equals("Thrid"))
//				array.remove(i);
//			i++;
//		}
//		
//		System.out.println();
//		arrayiter2 = array.iterator();
//		while(arrayiter2.hasNext())
//			System.out.println(arrayiter2.next());
		
		HashSet<String> hash = new HashSet<>();
		hash.add("Second");		
		hash.add("Thrid");
		hash.add("First");
		hash.add("Fourth");
		
		System.out.println("저장된 갯수 : "+hash.size());
		
		Iterator<String> iter = hash.iterator();
		
		while(iter.hasNext())
			System.out.println(iter.next());
	}
}
