package chapter11EX;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class Exercise11_1 {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> kyo = new ArrayList<>(); // 교집합
		ArrayList<Integer> cha = new ArrayList<>(); // 차집합
		ArrayList<Integer> hap = new ArrayList<>(); // 합집합
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		
		TreeSet<Integer> list3 = new TreeSet<>(list1);
		
		Iterator<Integer> list = list2.iterator();
		while(list.hasNext())
			list3.add(list.next());
		
		hap.addAll(list3);
		
		list3.addAll(list1);
		list3.removeAll(list2);		
		cha.addAll(list3);
		
		list3.addAll(list1);
		list3.retainAll(list2);
		kyo.addAll(list3);
		
		System.out.println("list1="+list1);
		System.out.println("list2="+list2);
		System.out.println("kyo="+kyo);
		System.out.println("cha="+cha);
		System.out.println("hap="+hap);
	}

}
